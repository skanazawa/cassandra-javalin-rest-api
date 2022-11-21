package com.mercadolibre.javalin.repositories.fulltextsearch;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.shaded.guava.common.base.Strings;
import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.FullTextSearch;

public class FullTextSearchRepositoryImpl implements FullTextSearchRepository {

  private static final String COUNT_TEXT_IN_MESSAGES = "SELECT count(*) as count FROM messages_by_id WHERE text LIKE :text";
  private static final String FIND_TEXT_BY_YEAR = "SELECT count(*) as count FROM messages_by_id WHERE year = :year AND text LIKE :text";
  private static final String PERCENT = "%";
  private final CqlSession session;

  @Inject
  public FullTextSearchRepositoryImpl(CqlSession session) {
    this.session = session;
  }

  @Override
  public Long fullTextSearch(FullTextSearch fts) {
    SimpleStatement simpleStatement;
    if (Strings.isNullOrEmpty(fts.getYear())) {
      simpleStatement =
          SimpleStatement.builder(COUNT_TEXT_IN_MESSAGES).addNamedValue("text", PERCENT.concat(fts.getText()).concat(PERCENT)).build();
    } else {
      simpleStatement =
          SimpleStatement.builder(FIND_TEXT_BY_YEAR)
              .addNamedValue("year", fts.getYear())
              .addNamedValue("text", PERCENT.concat(fts.getText()).concat(PERCENT)).build();
    }
    ResultSet resultSet = session.execute(simpleStatement);
    return resultSet.one().getLong("count");
  }
}
