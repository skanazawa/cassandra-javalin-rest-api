package com.mercadolibre.javalin.repositories.messages;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.google.inject.Inject;
import com.mercadolibre.javalin.domain.dtos.Message;
import java.util.function.Function;

public class MessagesRepositoryImpl implements MessagesRepository {


  private static final String COUNT_TEXT_IN_MESSAGES = "SELECT * FROM messages_by_id WHERE id = :id";
  private static final Function<Row,Message> mapMessage= row -> Message.builder()
      .id(row.getString("id"))
      .text(row.getString("text"))
      .build();
  private final CqlSession session;

  @Inject
  public MessagesRepositoryImpl(CqlSession session) {
    this.session = session;
  }

  @Override
  public Message getMessageById(String messageId) {
    SimpleStatement simpleStatement;
      simpleStatement =
          SimpleStatement.builder(COUNT_TEXT_IN_MESSAGES).addNamedValue("id",messageId).build();
    ResultSet resultSet = session.execute(simpleStatement);
    return mapMessage.apply(resultSet.one());
  }
}
