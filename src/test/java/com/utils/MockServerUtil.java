package com.utils;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServerUtil {

    private static WireMockServer  wireMockServer;

    public static void startMockServer() {
        // Start WireMock server
        wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort());
        wireMockServer.start();
    }

    public static void stopMockServer() {
        // Stop WireMock server
        wireMockServer.stop();
    }

    public static void configureMockResponse(String url, int statusCode, String responseBody) {
        WireMock.configureFor("localhost", wireMockServer.port());
        WireMock.stubFor(WireMock.post(WireMock.urlEqualTo(url))
                .willReturn(WireMock.aResponse()
                        .withStatus(statusCode)
                        .withBody(responseBody)));
    }
}
