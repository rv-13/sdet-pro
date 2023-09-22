package com.tests.assertj;

import com.utils.assertj.entity.Posts;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class PostAsserts extends AbstractAssert<PostAsserts, Posts> {
    protected PostAsserts(Posts posts, Class<?> selfType) {
        super(posts, selfType);
    }

    public static PostAsserts assertThat(Posts posts) {
        return new PostAsserts(posts, PostAsserts.class);
    }

    public PostAsserts hasId(int id) {
        Assertions.assertThat(actual)
                .extracting(Posts::getId)
                .withFailMessage("Id is not matching")
                .isEqualTo(id);
        return this;
    }
}
