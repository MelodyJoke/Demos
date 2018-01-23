package algorithms;

import java.util.concurrent.Flow;

public class TestFlow {

    public static void main(String... args) {
        /*TestPublisher publisher = new TestPublisher();

        TestSubscriber subscriber = new TestSubscriber();
        TestSubscriber subscriber2 = new TestSubscriber();

        publisher.subscribe(subscriber);
        publisher.subscribe(subscriber2);*/

        System.out.println("start");

        new Thread(() -> {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("awake");
        }).start();

        System.out.println("end");
    }
}

class TestPublisher implements Flow.Publisher<Boolean> {

    @Override
    public void subscribe(Flow.Subscriber<? super Boolean> subscriber) {
        subscriber.onSubscribe(new TestSubscription());
    }
}

class TestSubscription implements Flow.Subscription {

    @Override
    public void request(long n) {

    }

    @Override
    public void cancel() {

    }
}

class TestSubscriber implements Flow.Subscriber<Boolean> {

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(0);
    }

    @Override
    public void onNext(Boolean item) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}

