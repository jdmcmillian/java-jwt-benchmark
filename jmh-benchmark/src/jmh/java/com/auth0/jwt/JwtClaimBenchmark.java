package com.auth0.jwt;

import org.openjdk.jmh.annotations.Benchmark;

public class JwtClaimBenchmark {

    @Benchmark
    public Object jjwt_claim(BenchmarkState state) throws Exception {
		return state.getJavaJsonWebTokenVerifier().verifyJsonWebToken(state.getToken()).getBody().get("test", String.class);
    }
    
    @Benchmark
    public Object auth0_claim(BenchmarkState state) throws Exception {
    	return state.getAuth0TokenVerifier().verifyJsonWebToken(state.getToken()).getClaim("test");
    }
    
    @Benchmark
    public Object okta_claim(BenchmarkState state) throws Exception {
    	return state.getOktaJsonWebTokenVerifier().verifyJsonWebToken(state.getToken()).getClaims().get("test");
    }
}
