package br.com.richard.aprendizadographql.controller;

import br.com.richard.aprendizadographql.config.GraphQlConfig;
import br.com.richard.aprendizadographql.config.GraphQlVoidScalar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@Getter
@Import({GraphQlConfig.class, GraphQlVoidScalar.class})
public class GraphQlBaseTeste {

    @Autowired
    private GraphQlTester graphQlTester;

}
