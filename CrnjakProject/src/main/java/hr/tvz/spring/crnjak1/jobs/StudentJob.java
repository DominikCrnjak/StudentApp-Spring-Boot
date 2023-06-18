package hr.tvz.spring.crnjak1.jobs;

import hr.tvz.spring.crnjak1.repository.StudentRepositoryImplementation;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class StudentJob extends QuartzJobBean {
    private StudentRepositoryImplementation service;

    public StudentJob(StudentRepositoryImplementation service) {
        this.service = service;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("------List of students------");
        service.findAll().forEach(student -> {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        });
    }
}
