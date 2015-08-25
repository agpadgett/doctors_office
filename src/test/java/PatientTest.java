import org.junit.*;
import static org.junit.Assert.*;
// import anything else needed

public class PatientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(0, Patient.all().size());
  }

  @Test
  public void equals_returnTrueIfNamesAreTheSame() {
    Patient firstPatient = new Patient("John Doe", "January 1, 1965");
    Patient secondPatient = new Patient("John Doe", "January 1, 1965");
    assertEquals(true, firstPatient.equals(secondPatient));
  }

  @Test
  public void getName_returnsCorrectName(){
    Patient newPatient = new Patient("John Doe", "January 1, 1965");
    assertEquals("John Doe", newPatient.getName());
  }


  @Test
  public void getBirthday_returnsCorrectBDay(){
    Patient newPatient = new Patient("John Doe", "January 1, 1965");
    assertEquals("January 1, 1965", newPatient.getBirthday());
  }

  @Test
  public void save_returnTrueIfSaved(){
    Patient newPatient = new Patient("John Doe", "January 1, 1965");
    newPatient.save();
    assertTrue(Patient.all().get(0).equals(newPatient));
  }

  @Test
  public void getId_returnsIdAfterSave() {
    Patient newPatient = new Patient("John Doe", "January 1, 1965");
    newPatient.save();
    assertEquals(Patient.all().get(0).getId(), newPatient.getId());
  }

  @Test
  public void find_findsCorrectId(){
    Patient newPatient = new Patient("John Doe", "January 1, 1965");
    newPatient.save();
    Patient savedPatient = Patient.find(newPatient.getId());
    assertEquals(savedPatient, newPatient);
  }


  // @Test
  // public void methodName_whatIsBeingTested_desiredResult() {
  //   Class instance = new Class();
  //   assertEquals(expectedValue, instance.methodName(param));
  // }

}