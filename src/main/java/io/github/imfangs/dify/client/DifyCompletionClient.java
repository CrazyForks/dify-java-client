package io.github.imfangs.dify.client;

import io.github.imfangs.dify.client.callback.CompletionStreamCallback;
import io.github.imfangs.dify.client.exception.DifyApiException;
import io.github.imfangs.dify.client.model.common.SimpleResponse;
import io.github.imfangs.dify.client.model.completion.CompletionRequest;
import io.github.imfangs.dify.client.model.completion.CompletionResponse;

import java.io.IOException;

/**
 * Dify 文本生成型应用客户端接口
 * 包含文本生成型应用相关的功能
 */
public interface DifyCompletionClient extends DifyBaseClient {

    /**
     * 发送文本生成请求（阻塞模式）
     *
     * @param request 请求
     * @return 响应
     * @throws IOException IO异常
     * @throws DifyApiException API异常
     */
    CompletionResponse sendCompletionMessage(CompletionRequest request) throws IOException, DifyApiException;

    /**
     * 发送文本生成请求（流式模式）
     *
     * @param request  请求
     * @param callback 回调
     * @throws IOException IO异常
     * @throws DifyApiException API异常
     */
    void sendCompletionMessageStream(CompletionRequest request, CompletionStreamCallback callback) throws IOException, DifyApiException;

    /**
     * 停止文本生成
     *
     * @param taskId 任务 ID
     * @param user   用户标识
     * @return 响应
     * @throws IOException IO异常
     * @throws DifyApiException API异常
     */
    SimpleResponse stopCompletion(String taskId, String user) throws IOException, DifyApiException;

    /**
     * 文字转语音
     *
     * @param messageId 消息 ID
     * @param text      文本
     * @param user      用户标识
     * @return 音频数据
     * @throws IOException IO异常
     * @throws DifyApiException API异常
     */
    byte[] textToAudio(String messageId, String text, String user) throws IOException, DifyApiException;
}
