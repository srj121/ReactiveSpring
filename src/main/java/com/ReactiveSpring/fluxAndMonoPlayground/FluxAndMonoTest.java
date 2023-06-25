package com.ReactiveSpring.fluxAndMonoPlayground;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

@Test
    public void fluxTest1(){
       Flux<String> stringFlux = Flux.just("suraj","rahul","asif");

       stringFlux
               .subscribe(System.out::println);
    }
    @Test
    public void fluxTest2(){
        Flux<String> stringFlux = Flux.just("suraj","rahul","asif")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")));

        stringFlux
                .subscribe(System.out::println,(e) -> System.err.println(e));
    }

    @Test
    public void fluxTest3(){
        Flux<String> stringFlux = Flux.just("suraj","rahul","asif")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                        .log();

        stringFlux
                .subscribe(System.out::println,(e) -> System.err.println("Exception is = "+ e));
    }
    @Test
    public void fluxTest4(){
        Flux<String> stringFlux = Flux.just("suraj","rahul","asif")
                .concatWith(Flux.just("End"))
                .log();

        stringFlux
                .subscribe(System.out::println,(e) -> System.err.println("Exception is = "+ e));
    }

}
