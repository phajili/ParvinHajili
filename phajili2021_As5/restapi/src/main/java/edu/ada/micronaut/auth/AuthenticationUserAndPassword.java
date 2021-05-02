package edu.ada.micronaut.auth;


import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.annotation.Nullable;
import javax.inject.Singleton;
import java.util.ArrayList;


@Singleton
public class AuthenticationUserAndPassword implements AuthenticationProvider {

    @Override
    public Publisher<AuthenticationResponse> authenticate(
            @Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        System.out.println("AUTH WORKS");
        return Flowable.create(flowableEmitter -> {
            if (authenticationRequest.getIdentity().equals("Yahoo")
                    &&
                    authenticationRequest.getSecret().equals("Password")){

                flowableEmitter.onNext(
                        new UserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>()));
                flowableEmitter.onComplete();
            }
                else {
                    flowableEmitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }

        },
                BackpressureStrategy.ERROR);
    }
}
