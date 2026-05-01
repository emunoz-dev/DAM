package universitat;

public class GestorUniversitatsException extends Exception {
  private String errorCode = "unknown";
  private String errorMessage;

  public GestorUniversitatsException(String errorCode) {
    this.errorCode = errorCode;

    switch (errorCode) {
      case "1":
        errorMessage = "L'opció introduïda no és numèrica";
        break;
      case "2":
        errorMessage = "Ja no hi caben més Universitats";
        break;
      case "3":
        errorMessage = "La universitat ja existeix";
        break;
      case "GestorXML.model":
        errorMessage = "No s'ha pogut crear el model XML per desar la Universitat";
        break;
      case "GestorXML.desar":
        errorMessage = "No s'ha pogut desar la Universitat a causa d'error d'entrada/sortida";
        break;
      case "GestorXML.carrega":
        errorMessage = "No s'ha pogut carregar la Universitat a causa d'error d'entrada/sortida";
        break;
      default:
        errorMessage = "Error desconegut";
        break;
    }
  }

  public String getErrorMessage() {
    return "Error: " + errorCode + " ---- Message: " + errorMessage;
  }

}
