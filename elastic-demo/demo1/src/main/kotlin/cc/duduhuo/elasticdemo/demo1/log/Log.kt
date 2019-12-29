package cc.duduhuo.elasticdemo.demo1.log

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.*

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2019/12/29 18:36
 * Description:
 * Remarks:
 * =======================================================
 */
@Document(indexName = "log", shards = 1, replicas = 0)
data class Log(
    @Id
    @Field(type = FieldType.Keyword)
    var logId: String = "",

    @Field(type = FieldType.Keyword)
    var userId: String = "",

    @Field(type = FieldType.Text)
    var actionTime: String = "",

    @Field(type = FieldType.Text)
    var description: String = "",

    @Field(type = FieldType.Boolean)
    var success: Boolean = true,

    @Field(type = FieldType.Object)
    var userAgent: UserAgent = UserAgent()
) {
    data class UserAgent(
        @Field(type = FieldType.Keyword)
        var deviceClass: String = "",

        @MultiField(mainField = Field(type = FieldType.Text), otherFields = [
            InnerField(suffix = "keyword", type = FieldType.Keyword)
        ])
        var osName: String = "",

        @Field(type = FieldType.Keyword)
        var osVersion: String = "",

        @Field(type = FieldType.Keyword)
        var agentName: String = "",

        @Field(type = FieldType.Keyword)
        var agentVersionMajor: String = ""
    )
}