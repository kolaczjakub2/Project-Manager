package com.secondtonone.jk.jiraclone.fakeData;

import com.secondtonone.jk.jiraclone.domain.project.Project;
import com.secondtonone.jk.jiraclone.domain.project.Release;
import com.secondtonone.jk.jiraclone.domain.users.UserAccount;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ProjectRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.ReleaseRepository;
import com.secondtonone.jk.jiraclone.infrastrure.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class initData {

    private final ProjectRepository projectRepository;
    private final UserAccountRepository userAccountRepository;
    private final ReleaseRepository releaseRepository;

    @Autowired
    public initData(ProjectRepository projectRepository, UserAccountRepository userAccountRepository, ReleaseRepository releaseRepository) {
        this.projectRepository = projectRepository;
        this.userAccountRepository = userAccountRepository;
        this.releaseRepository = releaseRepository;
    }


    //@PostConstruct
    void init() {
        Project save1 = projectRepository.save(Project.builder()
                .withCode("BBB")
                .withDescription("aaaaa")
                .withName("aaaa")
                .build());
        Project save2 = projectRepository.save(Project.builder()
                .withCode("AAA")
                .withDescription("ccccaa")
                .withName("cccca")
                .build());
        Project save = projectRepository.save(Project.builder()
                .withCode("GGG")
                .withDescription("bbba")
                .withName("bbb")
                .build());


        userAccountRepository.save(UserAccount.builder()
                .withFirstName("default")
                .withLastName("default")
                .withUsername("default")
                .build());
        userAccountRepository.save(UserAccount.builder()
                .withId(UUID.fromString("8247995d-6909-4cba-968b-256a92922ef9"))
                .withFirstName("Jakub")
                .withLastName("Kołacz")
                .withUsername("pla131jakkola")
                .build());
        userAccountRepository.save(UserAccount.builder()
                .withFirstName("Anna")
                .withLastName("Test")
                .withUsername("pla123anntest")
                .build());


        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-11")
                .withProject(save)
                .build());
        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-12")
                .withProject(save)
                .build());
        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-13")
                .withProject(save)
                .build());
        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-11")
                .withProject(save1)
                .build());

        releaseRepository.save(Release.builder()
                .withLabel("2020-DEC-11")
                .withProject(save2)
                .build());

    }


}
