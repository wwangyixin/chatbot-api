package org.example.chatbot.api.domain.zsxq;

import org.example.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

public interface IZsxqApi {




    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String Cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}


















