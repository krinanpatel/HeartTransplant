

public class HeartTransplant {

   private Patient[] patients;
   private SurvivabilityByAge survivabilityByAge;
   private SurvivabilityByCause survivabilityByCause;
   public HeartTransplant() {
       patients=null;
       survivabilityByAge=null;
       survivabilityByCause=null;
   }
   
   public Patient[] getPatients() {
       return patients;
   } 
   
   public SurvivabilityByAge getSurvivabilityByAge() {
       return survivabilityByAge;
   }
   
   public SurvivabilityByCause getSurvivabilityByCause() {
       return survivabilityByCause;
   }

  
   public void readPatients (int numberOfLines) {
       patients=new Patient[numberOfLines];
       for (int i = 0; i < patients.length; i++) {
           int Id = StdIn.readInt();
           int Ethnicity = StdIn.readInt();
           int Gender = StdIn.readInt();
           int Age = StdIn.readInt();
           int Cause = StdIn.readInt();
           int Urgency = StdIn.readInt();
           int StateOfHealth = StdIn.readInt();
           patients[i] = new Patient(Id, Ethnicity, Gender, Age, Cause, Urgency, StateOfHealth);
       }
   }


   public void readSurvivabilityByAge (int numberOfLines) {
       survivabilityByAge=new SurvivabilityByAge();
       for(int i=0;i<numberOfLines;i++){
           int age = StdIn.readInt();
           int year = StdIn.readInt();
           double rate = StdIn.readDouble();
           survivabilityByAge.addData(age, year, rate);
       }
   }

  
   public void readSurvivabilityByCause (int numberOfLines) {
       survivabilityByCause=new SurvivabilityByCause();
       for(int i=0;i<numberOfLines;i++){
           int cause = StdIn.readInt();
           int year = StdIn.readInt();
           double rate = StdIn.readDouble();
           survivabilityByCause.addData(cause, year, rate);
       }
   }
   

   public Patient[] getPatientsWithAgeAbove(int age) {
       Patient[] patientsAboveAge;
       int l=0;
       for (Patient patient : patients) {
           if(patient!=null && patient.getAge()>age){
               l++;
           }
       }
       patientsAboveAge=new Patient[l];
       int i=0;
       for (Patient patient : patients){
           if(patient!=null && patient.getAge()>age){
               patientsAboveAge[i]=patient;
               i++;
           }
       }
       return patientsAboveAge;
   }

   
   public Patient[] getPatientsByHeartConditionCause(int cause) {
       Patient[] patientsByHeartConditionCause;
       int length=0;
       for (Patient patient : patients) 
           if(patient!=null && patient.getCause()==cause)
               length++;
       patientsByHeartConditionCause=new Patient[length];
       int i=0;
       for (Patient patient : patients)
           if(patient!=null && patient.getCause()==cause){
               patientsByHeartConditionCause[i]=patient;
               i++;
           }
       return patientsByHeartConditionCause;
   }

   
   public Patient[] getPatientsByurgency(int urgency) {
       Patient[] patientsByurgency;
       int length=0;
       for (Patient patient : patients) 
           if(patient!=null && patient.getUrgency()>=urgency)
               length++;
       patientsByurgency=new Patient[length];
       int i=0;
       for (Patient patient : patients)
           if(patient!=null && patient.getUrgency()>=urgency){
               patientsByurgency[i]=patient;
               i++;
           }
       return patientsByurgency;
   }

  