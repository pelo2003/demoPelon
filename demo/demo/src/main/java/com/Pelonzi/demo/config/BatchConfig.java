package com.Pelonzi.demo.config;

import com.Pelonzi.demo.model.Customers;
import com.Pelonzi.demo.service.CustomerItemProcessor;
import com.Pelonzi.demo.service.CustomerItemReader;
import com.Pelonzi.demo.service.CustomerItemWriter;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.*;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CustomerItemReader reader;
    private final CustomerItemProcessor processor;
    private final CustomerItemWriter writer;

    public BatchConfig(JobBuilderFactory jobBuilderFactory,
                       StepBuilderFactory stepBuilderFactory,
                       CustomerItemReader reader,
                       CustomerItemProcessor processor,
                       CustomerItemWriter writer) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Bean
    public Job customerJob() {
        return jobBuilderFactory.get("customerJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Customers, Customers>chunk(10)
                .reader(reader.reader())
                .processor(processor)
                .writer(writer)
                .build();
    }
}
