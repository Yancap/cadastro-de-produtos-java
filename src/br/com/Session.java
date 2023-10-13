package br.com;

import br.com.dto.users.SessionUserDTO;

public class Session {
  private static SessionUserDTO dataSession;

  public static void setDataSession(SessionUserDTO outDataSession) {
    dataSession = outDataSession;
  }
  public static String getName() {
    return dataSession.name();
  }
  public static String getEmail() {
    return dataSession.email();
  }


}
