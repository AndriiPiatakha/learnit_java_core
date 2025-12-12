package com.itbulls.learnit.javacore.oop.grasp.lowcoupling.solution.example1;

public class ConsoleAuditService implements AuditService {

    private final AuditLogger auditLogger;

    public ConsoleAuditService(AuditLogger auditLogger) {
        this.auditLogger = auditLogger;
    }

    @Override
    public void audit(String message) {
        auditLogger.log(message);
    }
}