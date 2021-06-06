package com.secondtonone.jk.jiraclone.fakeData;

import com.secondtonone.jk.jiraclone.domain.project.Project;
import com.secondtonone.jk.jiraclone.domain.project.Release;
import com.secondtonone.jk.jiraclone.domain.project.repositories.CommentRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.ReleaseRepository;
import com.secondtonone.jk.jiraclone.domain.project.repositories.TaskRepository;
import com.secondtonone.jk.jiraclone.domain.project.task.Comment;
import com.secondtonone.jk.jiraclone.domain.project.task.Task;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Priority;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Resolution;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.Status;
import com.secondtonone.jk.jiraclone.domain.project.task.enums.TaskType;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import com.secondtonone.jk.jiraclone.domain.users.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
public class initData {

    private final ProjectRepository projectRepository;
    private final UserAccountRepository userAccountRepository;
    private final ReleaseRepository releaseRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public initData(ProjectRepository projectRepository, UserAccountRepository userAccountRepository, ReleaseRepository releaseRepository, TaskRepository taskRepository, CommentRepository commentRepository) {
        this.projectRepository = projectRepository;
        this.userAccountRepository = userAccountRepository;
        this.releaseRepository = releaseRepository;
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
    }


    @PostConstruct
    void init() {

        UserAccount defaultUser = userAccountRepository.save(UserAccount.builder()
                .withFirstName("default")
                .withLastName("default")
                .withUsername("default")
                .build());

        UserAccount user = UserAccount.builder()
                .withId(UUID.fromString("8247995d-6909-4cba-968b-256a92922ef9"))
                .withFirstName("Jakub")
                .withLastName("Kołacz")
                .withUsername("pla131jakkola")
                .build();

        UserAccount userSaved = userAccountRepository.save(user);

        Project save1 = projectRepository.save(Project.builder()
                .withCode("APPSUPP")
                .withDescription("Cointains tickets requested by clients")
                .withName("App Support")
                .withLeader(defaultUser)
                .build());

        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-11")
                .withProject(save1)
                .build());
        Release release = Release.builder()
                .withLabel("2020-DEC-12")
                .withProject(save1)
                .build();

        releaseRepository.save(release);
        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-13")
                .withProject(save1)
                .build());

        Task task=Task.builder()
                .withSummary("AML-Guard not working properly")
                .withDescription("AML-Guard not working properly")
                .withEstimatedTime("5h")
                .withResolution(Resolution.NONE)
                .withTaskType(TaskType.TASK)
                .withKey(createTaskKey(release))
                .withAssignee(userSaved)
                .withCreator(userSaved)
                .withPriority(Priority.BLOCKER)
                .withRelease(release)
                .withStatus(Status.OPEN).build();

        Task taskSaved = taskRepository.save(task);

        Comment comment= Comment.builder()
                .withAuthor(userSaved)
                .withTask(taskSaved)
                .withContent("Problem is with proxy layer")
                .build();

        commentRepository.save(comment);

    }

    private String createTaskKey(Release release) {
        String projectCode = releaseRepository.getProjectCode(release.getId());
        long number = taskRepository.count();
        return projectCode + "-" + number;
    }


}
