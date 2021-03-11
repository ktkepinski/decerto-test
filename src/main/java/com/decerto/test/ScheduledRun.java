package com.decerto.test;

import com.decerto.test.data.Data;
import com.decerto.test.merger.adding.AddingDataMerger;
import com.decerto.test.source.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ScheduledRun {
    @Qualifier("javaRandomIntegerGenerator")
    private final DataSource<Integer> javaRandomIntegerGenerator;
    @Qualifier("randomOrgDataSource")
    private final DataSource<Integer> randomOrgDataSource;

    @Scheduled(fixedDelay = 5000)
    public void doInIntervals() {
        Data<Integer> first = javaRandomIntegerGenerator.getData();
        Data<Integer>  second = randomOrgDataSource.getData();
        System.out.println(first);
        System.out.println(second);
        Data<Integer>  result = new AddingDataMerger<Integer>().merge(Arrays.asList(first, second));
        System.out.println(result);
    }
}
