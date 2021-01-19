package com.secondtonone.jk.jiraclone.application.task.services;

import com.secondtonone.jk.jiraclone.domain.task.Task;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;

import java.util.List;
import java.util.Set;

public class GetHistoryCommand {


    private final AuditReader auditReader;

    public GetHistoryCommand(AuditReader auditReader) {
        this.auditReader = auditReader;
    }

    public Object execute(String key) {
//        AuditQuery auditQuery = auditReader.createQuery()
//                .forRevisionsOfEntityWithChanges(Task.class, true);
//
//        auditQuery.add(AuditEntity.property("key").eq(key));
//        return auditQuery.getResultList();
        List results = auditReader.createQuery().forRevisionsOfEntityWithChanges(Task.class, false)
                .add(AuditEntity.property("key").eq(key))
                .getResultList();

        Object previousEntity = null;
        for (Object row : results) {
            Object[] rowArray = (Object[]) row;
            final Task entity = (Task) rowArray[0];
            final RevisionType revisionType = (RevisionType) rowArray[2];
            final Set<String> propertiesChanged = (Set<String>) rowArray[3];
            for (String propertyName : propertiesChanged) {


                // using the property name here you know
                // 1. that the property changed in this revision (no compare needed)
                // 2. Can get old/new values easily from previousEntity and entity
            }
        }
        return null;
    }

}
