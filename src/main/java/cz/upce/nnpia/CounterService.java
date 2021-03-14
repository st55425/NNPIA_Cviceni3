package cz.upce.nnpia;

import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private int visitCount;
    private int subscribersCount;

    public CounterService() {
        visitCount = 0;
        subscribersCount = 0;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public int getSubscribersCount() {
        return subscribersCount;
    }

    public void addVisit(){
        visitCount++;
    }
    public void addSubscribersCount(){
        subscribersCount++;
    }
}
