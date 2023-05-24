package com.cindyhoang.guidemate.data.network

import com.cindyhoang.guidemate.data.model.GuidesResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Test
import java.lang.Exception

class GuideListParsingTest {
    @Test
    fun testParseValidJson() {
        val json = javaClass.classLoader?.getResource("valid_guide_list.json")?.readText()
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<GuidesResponse> = moshi.adapter(GuidesResponse::class.java)
        val guidesResponse: GuidesResponse? = adapter.fromJson(json)

        assert(guidesResponse?.guides?.isNotEmpty() == true)
        assert(guidesResponse!!.guides[0].name == "First")
    }

    @Test
    fun testParseInvalidJson() {
        val json = javaClass.classLoader?.getResource("invalid_guide_list_no_name.json")?.readText()
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<GuidesResponse> = moshi.adapter(GuidesResponse::class.java)
        var guidesResponse: GuidesResponse? = null

        try {
            guidesResponse = adapter.fromJson(json)
        } catch (e: Exception) {
            assert(guidesResponse == null)
        }
    }
}