package com.cindyhoang.guidemate.data.network

import com.cindyhoang.guidemate.data.model.Guide
import com.cindyhoang.guidemate.data.model.GuidesResponse
import com.cindyhoang.guidemate.data.model.ObjType
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import junit.framework.TestCase.assertNull
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

        val firstGuide: Guide? = guidesResponse?.guides?.get(0)
        assert(firstGuide!!.name == "First")
        assert(firstGuide.url == "/guide/1")
        assert(firstGuide.startDate == "Jan 1, 2023")
        assert(firstGuide.endDate == "Jan 2, 2023")
        assert(firstGuide.icon == "icon_url_1")
        assert(firstGuide.objType == ObjType.guide)
        assertNull(firstGuide.venue?.city)
        assertNull(firstGuide.venue?.state)
        assert(!firstGuide.loginRequired)
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