package hr.tvz.spring.crnjak1.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfiguration {

    @Bean
    public JobDetail studentJobDetail(){
        return JobBuilder.newJob(StudentJob.class).withIdentity("Student list job").storeDurably().build();
    }
    @Bean
    public SimpleTrigger studentJobTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(100).repeatForever();

        return TriggerBuilder.newTrigger().forJob(studentJobDetail()).withIdentity("Student list trigger").withSchedule(scheduleBuilder).build();
    }
}
