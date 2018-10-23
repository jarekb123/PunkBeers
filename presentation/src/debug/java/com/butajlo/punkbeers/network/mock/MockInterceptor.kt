package com.butajlo.punkbeers.network.mock

import com.butajlo.punkbeers.prefs.DebugPreferences
import okhttp3.*
import javax.inject.Inject

class MockInterceptor @Inject constructor(private val mockResponseFactory: MockResponseFactory,
                                          private val debugPreferences: DebugPreferences): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(debugPreferences.isMockResponsesEnabled) {
            val mockResponse = mockResponseFactory.getMockResponses(chain.request())
            if(mockResponse != null) {
                return Response.Builder()
                        .message("")
                        .protocol(Protocol.HTTP_1_1)
                        .request(chain.request())
                        .code(200)
                        .body(ResponseBody.create(MediaType.parse("text/json"), mockResponse))
                        .build()
            }
        }
        return chain.proceed(chain.request())
    }
}