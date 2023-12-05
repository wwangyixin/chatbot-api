package org.example.chatbot.api.test;

import io.github.bonigarcia.wdm.online.HttpClient;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class Apitest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112841114144/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=0FCC226C-C9B3-7AB4-A15A-DFCF544CDC71_C392342114688BF7; zsxqsessionid=bec0aa33fda7a1222a7cc076a3da9db9; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184542815415282%22%2C%22first_id%22%3A%2218c34fe89e8be-0975022d5ee2928-4c657b58-1327104-18c34fe89e99ba%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjMzRmZTg5ZThiZS0wOTc1MDIyZDVlZTI5MjgtNGM2NTdiNTgtMTMyNzEwNC0xOGMzNGZlODllOTliYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NDU0MjgxNTQxNTI4MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184542815415282%22%7D%2C%22%24device_id%22%3A%2218c34fe89e8be-0975022d5ee2928-4c657b58-1327104-18c34fe89e99ba%22%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811458121818512/comments");
        post.addHeader("cookie", "zsxq_access_token=0FCC226C-C9B3-7AB4-A15A-DFCF544CDC71_C392342114688BF7; zsxqsessionid=bec0aa33fda7a1222a7cc076a3da9db9; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184542815415282%22%2C%22first_id%22%3A%2218c34fe89e8be-0975022d5ee2928-4c657b58-1327104-18c34fe89e99ba%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjMzRmZTg5ZThiZS0wOTc1MDIyZDVlZTI5MjgtNGM2NTdiNTgtMTMyNzEwNC0xOGMzNGZlODllOTliYSIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NDU0MjgxNTQxNTI4MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184542815415282%22%7D%2C%22%24device_id%22%3A%2218c34fe89e8be-0975022d5ee2928-4c657b58-1327104-18c34fe89e99ba%22%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"中午太阳！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");

        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
