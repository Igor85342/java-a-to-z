package ru.moskalets.chapter003.controlquestion.task002;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Класс реализует триггер для запуска приложения раз в день.
 */
public class Trigger {
    /**
     * time.
     */
    private String time;

    /**
     * Конструктор.
     * @param time
     */
    public Trigger(String time) {
        this.time = time;
    }

    /**
     * Метод запускает приложение каждый день.
     * @throws Exception
     */
    public void triggerStart() throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        JobDetail job = newJob(Application.class)
                .withIdentity("job1", "group1")
                .build();

        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule(this.time))
                .build();

        sched.scheduleJob(job, trigger);
        sched.start();
    }
}