import java.util.ArrayList;
import java.util.List;


interface Observer {
    void update(String message);
}


interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}


class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }
}


class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}


public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        
        Observer channel1 = new NewsChannel("Channel 1");
        Observer channel2 = new NewsChannel("Channel 2");

        
        newsAgency.attach(channel1);
        newsAgency.attach(channel2);

        
        newsAgency.setNews("Breaking News: Observer Pattern in Action!");
        
       
        newsAgency.detach(channel1);
        
        
        newsAgency.setNews("Update: Observer Pattern Example Complete!");
    }
}
