/**
 * Takes name and creates username and email address, if not full name then name is set to
 * "default". Takes in password and confirms it contains uppercase, lowercase, and special
 * character. If not, password is set to "pw".
 *
 * @author Zachery Danis
 */
public class Employee {
  public String name;
  public String username;
  public String password;
  public String email;

  private void setUsername() {
    String firstInitial = username.substring(0, 1);
    String[] lastName = username.split(" ");
    username = firstInitial.concat(lastName[1]);
  }

  /**
   * Determines if the name that was entered is the first and last name. If not, username is set to
   * "default" and email is set to "user@oracleacademy.Test"
   *
   * @param name First and last name of employee
   * @return confirms if the name is entered correctly
   */
  private boolean checkName(String name) {
    if (name.contains(" ")) {
      setUsername();
      setEmail();
      return false;
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
      return true;
    }
  }

  private void setEmail() {
    String[] firstName = email.split(" ");
    email = firstName[0].concat(".").concat(firstName[1]).concat("@oracleacademy");
  }

  /**
   * Determines is the password contains uppercase, lowercase, and special character. If not, sets
   * password as "pw"
   *
   * @param pass assigns temp value to confirm if password is valid
   * @return password is valid
   */
  private boolean isValidPassword(String pass) {
    pass = " ";
    String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
    for (int i = 0; i < password.length(); i++) {
      if (password.substring(i).matches("[A-Z]") || specialChars.contains(password.substring(i))) {
        if ((password.substring(i).matches("[a-z]"))
            || specialChars.contains(password.substring(i))) {
          pass = password;
          return true;
        }
      }
    }
    if (pass.equals(password)) {
      return true;
    } else {
      password = "pw";
      return false;
    }
  }

  /**
   * Assigns values to username, email, and password based on user input. calls checkName and
   * isValidPassword
   *
   * @param name Full name of the employee
   * @param password password they created
   */
  public Employee(String name, String password) {
    username = name;
    email = name;
    this.name = name;
    checkName(name);
    this.password = password;
    isValidPassword(this.password);
  }

  /**
   * Sets the values for Employee to a String so they can be printed.
   *
   * @return Print out of what the Employee sets
   *
   */
  public String toString() {
    return "Employee Details"
        + "\n"
        + "Name : "
        + name
        + "\n"
        + "Username : "
        + username.toLowerCase()
        + "\n"
        + "Email : "
        + email.toLowerCase()
        + ".Test"
        + "\n"
        + "Initial Password : "
        + password;
  }
}
