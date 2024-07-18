package com.ibm.langchain4j.watsonx.deployment;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import dev.langchain4j.model.ModelDisabledException;
import dev.langchain4j.model.chat.ChatLanguageModel;
import io.quarkus.test.QuarkusUnitTest;

public class DisabledChatModelTest {

    @RegisterExtension
    static QuarkusUnitTest unitTest = new QuarkusUnitTest()
            .withEmptyApplication()
            .overrideRuntimeConfigKey("quarkus.langchain4j.watsonx.enable-integration", "false");

    @Inject
    ChatLanguageModel model;

    @Test
    void test() {
        assertThatThrownBy(() -> model.generate("test")).isInstanceOf(ModelDisabledException.class);
    }
}
