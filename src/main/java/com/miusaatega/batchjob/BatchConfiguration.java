package com.miusaatega.batchjob;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Student> reader() {
        return new FlatFileItemReaderBuilder<Student>()
                .name("studentFileReader")
                .resource(new ClassPathResource("myData.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName", "gpa", "age"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>()
                {{
                    setTargetType(Student.class);
                }}).build();
    }

    @Bean
    public Processor processor() {
        return new Processor();
    }



    /*@Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Student> writer) {
        return stepBuilderFactory.get("step1")
                .<Student, Student> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }*/
}
