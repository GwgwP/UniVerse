package gr.aueb.softeng.team02.dao;

import android.util.Log;

import java.sql.Date;
import java.time.LocalDate;

import gr.aueb.softeng.team02.memorydao.SecretaryDAOMemory;
import gr.aueb.softeng.team02.memorydao.StudentDAOMemory;
import gr.aueb.softeng.team02.memorydao.SubjectDAOMemory;
import gr.aueb.softeng.team02.model.AcademicYear;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.model.Circumscription;
import gr.aueb.softeng.team02.model.Grade;
import gr.aueb.softeng.team02.model.OfferedSubject;
import gr.aueb.softeng.team02.model.Secretary;
import gr.aueb.softeng.team02.model.Student;
import gr.aueb.softeng.team02.model.Subject;

public abstract class Initializer {

    //διαγράφουμε όλα τα δεδομένα στη βάση δεδομένων
    protected abstract void eraseData();

    public abstract SecretaryDAO getSecretaryDAO();

    public abstract StudentDAO getStudentDAO();

    public abstract AcademicYearDAO getAcademicYearDAO();

    public abstract OfferedSubjectDAO getOfferedSubjectDAO();

    public abstract SubjectDAO getSubjectDAO();

    public abstract SubmissionDAO getSubmissionSAO();

    public abstract GradeDAO getGradeDAO();

    public void prepareData() throws AcademicYearException {
        Student s1 = new Student(3200125, "p3200125", "Irma", "Lydia-Christina", "Wallace", 6);
        Student s2 = new Student(3200155, "p3200155", "Well", "Georgia", "Petsa", 6);
        Student s3 = new Student(3200199, "p3200199", "Link", "Panagiotis", "Triantafillidis", 6);

        Secretary r1 = new Secretary(12345, "p12345", "0000", "Eusta8ios", "Xaralampidhs");

        Subject b1 = new Subject(123, "ak", 5, "alalal", "title");

        getStudentDAO().save(s1);
        getStudentDAO().save(s2);
        getStudentDAO().save(s3);

        getSecretaryDAO().save(r1);

        AcademicYear y2 = new AcademicYear("2022-2023");
        AcademicYear y1 = new AcademicYear("2021-2022");

        LocalDate start1 = LocalDate.of(2022, 10, 15);
        LocalDate end1 = LocalDate.of(2022, 11, 15);

        LocalDate start2 = LocalDate.of(2023, 3, 15);
        LocalDate end2 = LocalDate.of(2023, 4, 15);

        LocalDate start = LocalDate.of(2021, 10, 15);
        LocalDate end = LocalDate.of(2021, 11, 15);

        LocalDate start0 = LocalDate.of(2022, 3, 15);
        LocalDate end0 = LocalDate.of(2022, 4, 15);

        Circumscription c1 = new Circumscription(1, 30, start, end);
        Circumscription c2 = new Circumscription(2, 30, start0, end0);
        Circumscription c3 = new Circumscription(3, 30, start, end);
        Circumscription c4 = new Circumscription(4, 30, start0, end0);
        Circumscription c5 = new Circumscription(5, 30, start, end);
        Circumscription c6 = new Circumscription(6, 30, start0, end0);
        Circumscription c7 = new Circumscription(7, 30, start, end);
        Circumscription c8 = new Circumscription(8, 30, start0, end0);

        y1.addCircumscription(c1);
        y1.addCircumscription(c2);
        y1.addCircumscription(c3);
        y1.addCircumscription(c4);
        y1.addCircumscription(c5);
        y1.addCircumscription(c6);
        y1.addCircumscription(c7);
        y1.addCircumscription(c8);

        Circumscription c11 = new Circumscription(1, 30, start1, end1);
        Circumscription c21 = new Circumscription(2, 30, start2, end2);
        Circumscription c31 = new Circumscription(3, 30, start1, end1);
        Circumscription c41 = new Circumscription(4, 30, start2, end2);
        Circumscription c51 = new Circumscription(5, 30, start1, end1);
        Circumscription c61 = new Circumscription(6, 30, start2, end2);
        Circumscription c71 = new Circumscription(7, 30, start1, end1);
        Circumscription c81 = new Circumscription(8, 30, start2, end2);

        y2.addCircumscription(c11);
        y2.addCircumscription(c21);
        y2.addCircumscription(c31);
        y2.addCircumscription(c41);
        y2.addCircumscription(c51);
        y2.addCircumscription(c61);
        y2.addCircumscription(c71);
        y2.addCircumscription(c81);


        getAcademicYearDAO().save(y1);
        getAcademicYearDAO().save(y2);


        // 1st semester
        Subject su1 = new Subject(0, "Stauros Toumpis", 8, "", "Algebra 1");

        Subject su2 = new Subject(1, "Antonis Dimakis", 8, "Η έννοια του προγράμματος. Μεταβλητές, τύποι μεταβλητών, εκφράσεις και αριθμητικοί υπολογισμοί. Δομές ελέγχου και δομές" +
                "επανάληψης της γλώσσας Python. Είσοδος/έξοδος δεδομένων. Εντοπισμός και άρση σφαλμάτων. Συναρτήσεις και μέθοδοι. Η έννοια" +
                "του αλγορίθμου. Σχεδίαση αλγορίθμων και αρχές δομημένου προγραμματισμού. Δομημένοι τύποι, αλφαριθμητικά, λίστες, πίνακες." +
                "Αλγόριθμοι αναζήτησης, αλγόριθμοι ταξινόμησης, μαθηματικά προβλήματα. Αρχεία δεδομένων. Η έννοια της αναδρομής," +
                "αναδρομικές συναρτήσεις, σχέση μεταξύ επανάληψης και αναδρομής. Βασικές έννοιες συναρτησιακού και αντικειμενοστρεφούς" +
                "προγραμματισμού στην γλώσσα Python", "Python");
        Subject su3 = new Subject(2, "Iordanis Koutsopoulos", 8, "Αλγόριθμοι και αρχές προγραμματισμού υπολογιστών (βασική λογική, στοιχειοποίηση, ακολουθία, επανάληψη, αναδρομή,\" +\n" +
                "                \"αποδοτικότητα αλγορίθμων). Δομές δεδομένων (πίνακες, λίστες, στοίβες, δέντρα). Θεωρία υπολογισμού (υπολογισιμότητα και " +
                "                \"πολυπλοκότητα, κλάσεις P και NP). Αρχιτεκτονική υπολογιστών (λογικές πύλες, εκτέλεση εντολών, μνήμη, αρχιτεκτονική μηχανής," +
                "                \"γλώσσα μηχανής, μεταβίβαση παραμέτρων, μονάδες εισόδου/εξόδου). Γλώσσες προγραμματισμού (γραμματικές, συντακτική\" +\n" +
                "                \"ανάλυση, μεταγλωττιστές). Λειτουργικά συστήματα (διεργασίες, χρονοπρογραμματισμός). Συστήματα αρχείων και βάσεων\" +\n" +
                "                \"δεδομένων. Δίκτυα υπολογιστών και Διαδίκτυο (βασικά πρωτόκολλα διαδικτύου, HTML, TCP, WiFi).", "Computer Science");

        Subject su4 = new Subject(3, "Trufon Trufonas", 8, "Εισαγωγή στο περιεχόμενο και τη μεθοδολογία της οικονομικής επιστήμης. Μηχανισμοί λειτουργίας της αγοράς. Συμπεριφορά του" +
                "καταναλωτή και θεωρία ζήτησης και προσφοράς των αγαθών. Οργάνωση και συμπεριφορά της επιχείρησης. Θεωρία παραγωγής και" +
                "κόστους. Ανάλυση των μορφών αγοράς (ανταγωνισμός, μονοπώλιο, ολιγοπώλιο). Εισαγωγή στη μακροοικονομική ανάλυση." +
                "Παρουσίαση και μέτρηση των μακροοικονομικών μεγεθών. Βασικά χαρακτηριστικά της οικονομικής ανάπτυξης και των οικονομικών" +
                "κύκλων. Παρουσίαση και ανάλυση των μακροοικονομικών στοιχείων της Ελλάδας και άλλων χωρών της Ευρωπαϊκής Ένωσης με" +
                "έμφαση στα δημοσιονομικά μεγέθη, καθώς και τα θέματα παραγωγικότητας και ανταγωνιστικότητας ελληνικής οικονομίας.", "Economics 1");

        Subject su5 = new Subject(4, "Panagiotis Katerinis", 8, "Σύνολα. Σχέσεις. Συναρτήσεις. Φυσικοί Αριθμοί. Αρχή της επαγωγής. Ισοδυναμία συνόλων. " +
                "Αριθμήσιμα και υπεραριθμήσιμα σύνολα.Προτασιακός λογισμός. Πράξεις μεταξύ συνόλων και λογικοί σύνδεσμοι. Άλγεβρα Boole. " +
                "Τι είναι απόδειξη και τεχνικές απόδειξης. Βασικές αρχές απαρίθμησης. Διατάξεις. Συνδυασμοί. Η αρχή του εγκλεισμού και αποκλεισμού" +
                ". Γραφήματα. Ισομορφισμός γραφημάτων. Μονοπάτια, κύκλοι και συνεκτικότητα. Πίνακες γραφημάτων. Κατευθυνόμενα γραφήματα. " +
                "Δέντρα. Το πρόβλημα του βέλτιστου επικαλυπτικού δέντρου. Δέντρα με ρίζες. Ίχνη του Euler και κύκλοι του Hamilton. " +
                "Επίπεδα γραφήματα και χρωματισμός γραφημάτων. Γραμμικές αναδρομικές σχέσεις με σταθερούς συντελεστές", "Discrete Mathematics");
        // 2nd semester
        Subject su6 = new Subject(5, "George Koutsikas", 8, "Introduction on object-oriented programming", "Java");
        Subject su7 = new Subject(6, "Despoina Sapouna", 8, "Introduction on Business Management", "Business Management");
        Subject su8 = new Subject(7, "Stauros Toumpis", 8, "Introduction on Possibilities", "Possibilities");
        Subject su9 = new Subject(8, "Trufon Trufonas", 8, "Introduction on linear algebra", "Linear Algebra");
        Subject su10 = new Subject(9, "George Poluzos", 8, "Introduction on Design and analysis of digital systems", "Design and analysis of digital systems");
        // 3rd semester
        Subject su11 = new Subject(10, "George Papaioanou", 8, "Introduction on object-oriented and memory management programming", "C++");
        Subject su12 = new Subject(11, "John Voulgaris", 8, "Introduction on computer systems organization", "Computer systems organization");
        Subject su13 = new Subject(12, "Paris Bassalos", 8, "Introduction on computational mathematics", "Computational mathematics");
        Subject su14 = new Subject(13, "John Markakis", 8, "Introduction on data structures", "Data structures");
        // 4th semester
        Subject su15 = new Subject(14, "Bill Bassalos", 8, "Introduction on data bases", "Data Bases");
        Subject su16 = new Subject(15, "George Xulomenos", 8, "Introduction on operating systems", "Operating Systems");
        Subject su17 = new Subject(16, "Katia Papakontantinopoulou", 8, "Introduction on algorithms", "Algorithms");
        Subject su18 = new Subject(17, "Eugene Foustoukou", 8, "Introduction on automata systems", "Automata Systems");
        // 5th semester
        Subject su19 = new Subject(18, "Eugene Foustoukou", 8, "Introduction on logic", "Logic");
        Subject su20 = new Subject(19, "Ion Androutsopoulos", 8, "Introduction on Artificial Intelligence", "Artificial Intelligence");
        Subject su21 = new Subject(20, "Antonis Dimakis", 8, "Introduction on statistics", "Statistics");
        Subject su22 = new Subject(21, "Anna Kefala", 8, "Introduction on networking", "Networking Systems");
        Subject su23 = new Subject(22, "John Kapeths", 8, "Introduction on software developing techniques", "ASPS");
        // 6th semester
        Subject su24 = new Subject(23, "Software development", 8, "Introduction on application development", "Software Development");
        Subject su25 = new Subject(24, "John Kotidis", 8, "Introduction on management and database systems", "SDAD");
        Subject su26 = new Subject(25, "Antonis Dimakis", 8, "Introduction on optimization theory", "Optimization Theory");
        Subject su27 = new Subject(26, "Vana Kalogeraki", 8, "Introduction on networking", "Distributed Systems");
        Subject su28 = new Subject(27, "John Maleuris", 8, "Introduction on software verification and validation", "Software Verification and Validation");
        // 7th semester
        Subject su29 = new Subject(28, "Bill Zafeirhs", 8, "Introduction on Web technologies and programming", " Web Development");
        Subject su30 = new Subject(29, "Ion Androutsopoulos", 8, "Introduction on machine learning", "Machine Learning");
        Subject su31 = new Subject(30, "George Xulomenos", 8, "Introduction on multimedia technology", "Multimedia technology");
        Subject su32 = new Subject(31, "John Markakis", 8, "Introduction on special topics in algorithms", "Special topics in algorithms");
        // 8th semester
        Subject su33 = new Subject(32, "John Kotidis", 8, "Introduction on development of information systems", "Development of information systems");
        Subject su34 = new Subject(33, "Ion Androutsopoulos", 8, "Introduction on interaction of human with computer", "Interaction of human with computer");
        Subject su35 = new Subject(34, "Eugene Foustoukou", 8, "Introduction on theory of computability and complexity", "Theory of computability and complexity");
        Subject su36 = new Subject(35, "Euagellia Vagena", 8, "Introduction on Elements of law and information", "Elements of law and information");

        OfferedSubject o1 = new OfferedSubject(1, su1, y1);
        OfferedSubject o2 = new OfferedSubject(1, su2, y1);
        OfferedSubject o3 = new OfferedSubject(1, su3, y1);
        OfferedSubject o4 = new OfferedSubject(1, su4, y1);
        OfferedSubject o5 = new OfferedSubject(1, su5, y1);

        OfferedSubject o6 = new OfferedSubject(2, su6, y1);
        OfferedSubject o7 = new OfferedSubject(2, su7, y1);
        OfferedSubject o8 = new OfferedSubject(2, su8, y1);
        OfferedSubject o9 = new OfferedSubject(2, su9, y1);
        OfferedSubject o10 = new OfferedSubject(2, su10, y1);

        OfferedSubject o11 = new OfferedSubject(3, su11, y1);
        OfferedSubject o12 = new OfferedSubject(3, su12, y1);
        OfferedSubject o13 = new OfferedSubject(3, su13, y1);
        OfferedSubject o14 = new OfferedSubject(3, su14, y1);

        OfferedSubject o15 = new OfferedSubject(4, su15, y1);
        OfferedSubject o16 = new OfferedSubject(4, su16, y1);
        OfferedSubject o17 = new OfferedSubject(4, su17, y1);
        OfferedSubject o18 = new OfferedSubject(4, su18, y1);

        OfferedSubject o19 = new OfferedSubject(5, su19, y1);
        OfferedSubject o20 = new OfferedSubject(5, su20, y1);
        OfferedSubject o21 = new OfferedSubject(5, su21, y1);
        OfferedSubject o22 = new OfferedSubject(5, su22, y1);
        OfferedSubject o23 = new OfferedSubject(5, su23, y1);

        OfferedSubject o24 = new OfferedSubject(6, su24, y1);
        OfferedSubject o25 = new OfferedSubject(6, su25, y1);
        OfferedSubject o26 = new OfferedSubject(6, su26, y1);
        OfferedSubject o27 = new OfferedSubject(6, su27, y1);
        OfferedSubject o28 = new OfferedSubject(6, su28, y1);

        OfferedSubject o29 = new OfferedSubject(7, su29, y1);
        OfferedSubject o30 = new OfferedSubject(7, su30, y1);
        OfferedSubject o31 = new OfferedSubject(7, su31, y1);
        OfferedSubject o32 = new OfferedSubject(7, su32, y1);

        OfferedSubject o33 = new OfferedSubject(8, su33, y1);
        OfferedSubject o34 = new OfferedSubject(8, su34, y1);
        OfferedSubject o35 = new OfferedSubject(8, su35, y1);
        OfferedSubject o36 = new OfferedSubject(8, su36, y1);

        OfferedSubject k1 = new OfferedSubject(1, su1, y2);
        OfferedSubject k2 = new OfferedSubject(1, su2, y2);
        OfferedSubject k3 = new OfferedSubject(1, su3, y2);
        OfferedSubject k4 = new OfferedSubject(1, su4, y2);
        OfferedSubject k5 = new OfferedSubject(1, su5, y2);

        OfferedSubject k6 = new OfferedSubject(2, su6, y2);
        OfferedSubject k7 = new OfferedSubject(2, su7, y2);
        OfferedSubject k8 = new OfferedSubject(2, su8, y2);
        OfferedSubject k9 = new OfferedSubject(2, su9, y2);
        OfferedSubject k10 = new OfferedSubject(2, su10, y2);

        OfferedSubject k11 = new OfferedSubject(3, su11, y2);
        OfferedSubject k12 = new OfferedSubject(3, su12, y2);
        OfferedSubject k13 = new OfferedSubject(3, su13, y2);
        OfferedSubject k14 = new OfferedSubject(3, su14, y2);

        OfferedSubject k15 = new OfferedSubject(4, su15, y2);
        OfferedSubject k16 = new OfferedSubject(4, su16, y2);
        OfferedSubject k17 = new OfferedSubject(4, su17, y2);
        OfferedSubject k18 = new OfferedSubject(4, su18, y2);

        OfferedSubject k19 = new OfferedSubject(5, su19, y2);
        OfferedSubject k20 = new OfferedSubject(5, su20, y2);
        OfferedSubject k21 = new OfferedSubject(5, su21, y2);
        OfferedSubject k22 = new OfferedSubject(5, su22, y2);
        OfferedSubject k23 = new OfferedSubject(5, su23, y2);

        OfferedSubject k24 = new OfferedSubject(8, su24, y2);
        OfferedSubject k25 = new OfferedSubject(8, su25, y2);
        OfferedSubject k26 = new OfferedSubject(8, su26, y2);
        OfferedSubject k27 = new OfferedSubject(8, su27, y2);
        OfferedSubject k28 = new OfferedSubject(8, su28, y2);

        OfferedSubject k29 = new OfferedSubject(7, su29, y2);
        OfferedSubject k30 = new OfferedSubject(7, su30, y2);
        OfferedSubject k31 = new OfferedSubject(7, su31, y2);
        OfferedSubject k32 = new OfferedSubject(7, su32, y2);

        OfferedSubject k33 = new OfferedSubject(6, su33, y2);
        OfferedSubject k34 = new OfferedSubject(6, su34, y2);
        OfferedSubject k35 = new OfferedSubject(6, su35, y2);
        OfferedSubject k36 = new OfferedSubject(6, su36, y2);

        Grade g1 = new Grade(s1, o1, 8);
        Grade g2 = new Grade(s1, o2, 9);
        Grade g3 = new Grade(s1, o3, 10);
        Grade g4 = new Grade(s1, o4, 5);
        Grade g5 = new Grade(s1, o5, 9);

        Grade g6 = new Grade(s1, o6, 9);
        Grade g7 = new Grade(s1, o7, 9);
        Grade g8 = new Grade(s1, o8, 9);
        Grade g9 = new Grade(s1, o9, 9);
        Grade g10 = new Grade(s1, o10, 9);

        getGradeDAO().save(g1);
        getGradeDAO().save(g2);
        getGradeDAO().save(g3);
        getGradeDAO().save(g4);
        getGradeDAO().save(g5);
        getGradeDAO().save(g6);
        getGradeDAO().save(g7);
        getGradeDAO().save(g8);
        getGradeDAO().save(g9);
        getGradeDAO().save(g10);

        getSubjectDAO().save(su1);
        getSubjectDAO().save(su2);
        getSubjectDAO().save(su3);
        getSubjectDAO().save(su4);
        getSubjectDAO().save(su5);

        getSubjectDAO().save(su6);
        getSubjectDAO().save(su7);
        getSubjectDAO().save(su8);
        getSubjectDAO().save(su9);
        getSubjectDAO().save(su10);

        getSubjectDAO().save(su11);
        getSubjectDAO().save(su12);
        getSubjectDAO().save(su13);
        getSubjectDAO().save(su14);

        getSubjectDAO().save(su15);
        getSubjectDAO().save(su16);
        getSubjectDAO().save(su17);
        getSubjectDAO().save(su18);

        getSubjectDAO().save(su19);
        getSubjectDAO().save(su20);
        getSubjectDAO().save(su21);
        getSubjectDAO().save(su22);
        getSubjectDAO().save(su23);

        getSubjectDAO().save(su24);
        getSubjectDAO().save(su25);
        getSubjectDAO().save(su26);
        getSubjectDAO().save(su27);
        getSubjectDAO().save(su28);

        getSubjectDAO().save(su29);
        getSubjectDAO().save(su30);
        getSubjectDAO().save(su31);
        getSubjectDAO().save(su32);

        getSubjectDAO().save(su33);
        getSubjectDAO().save(su34);
        getSubjectDAO().save(su35);
        getSubjectDAO().save(su36);

        getOfferedSubjectDAO().save(o1);
        getOfferedSubjectDAO().save(o2);
        getOfferedSubjectDAO().save(o3);
        getOfferedSubjectDAO().save(o4);
        getOfferedSubjectDAO().save(o5);

        getOfferedSubjectDAO().save(o6);
        getOfferedSubjectDAO().save(o7);
        getOfferedSubjectDAO().save(o8);
        getOfferedSubjectDAO().save(o9);
        getOfferedSubjectDAO().save(o10);

        getOfferedSubjectDAO().save(o11);
        getOfferedSubjectDAO().save(o12);
        getOfferedSubjectDAO().save(o13);
        getOfferedSubjectDAO().save(o14);

        getOfferedSubjectDAO().save(o15);
        getOfferedSubjectDAO().save(o16);
        getOfferedSubjectDAO().save(o17);
        getOfferedSubjectDAO().save(o18);

        getOfferedSubjectDAO().save(o19);
        getOfferedSubjectDAO().save(o20);
        getOfferedSubjectDAO().save(o21);
        getOfferedSubjectDAO().save(o22);
        getOfferedSubjectDAO().save(o23);

        getOfferedSubjectDAO().save(o24);
        getOfferedSubjectDAO().save(o25);
        getOfferedSubjectDAO().save(o26);
        getOfferedSubjectDAO().save(o27);
        getOfferedSubjectDAO().save(o28);

        getOfferedSubjectDAO().save(o29);
        getOfferedSubjectDAO().save(o30);
        getOfferedSubjectDAO().save(o31);
        getOfferedSubjectDAO().save(o32);

        getOfferedSubjectDAO().save(o33);
        getOfferedSubjectDAO().save(o34);
        getOfferedSubjectDAO().save(o35);
        getOfferedSubjectDAO().save(o36);

        getOfferedSubjectDAO().save(k1);
        getOfferedSubjectDAO().save(k2);
        getOfferedSubjectDAO().save(k3);
        getOfferedSubjectDAO().save(k4);
        getOfferedSubjectDAO().save(k5);

        getOfferedSubjectDAO().save(k6);
        getOfferedSubjectDAO().save(k7);
        getOfferedSubjectDAO().save(k8);
        getOfferedSubjectDAO().save(k9);
        getOfferedSubjectDAO().save(k10);

        getOfferedSubjectDAO().save(k11);
        getOfferedSubjectDAO().save(k12);
        getOfferedSubjectDAO().save(k13);
        getOfferedSubjectDAO().save(k14);

        getOfferedSubjectDAO().save(k15);
        getOfferedSubjectDAO().save(k16);
        getOfferedSubjectDAO().save(k17);
        getOfferedSubjectDAO().save(k18);

        getOfferedSubjectDAO().save(k19);
        getOfferedSubjectDAO().save(k20);
        getOfferedSubjectDAO().save(k21);
        getOfferedSubjectDAO().save(k22);
        getOfferedSubjectDAO().save(k23);

        getOfferedSubjectDAO().save(k24);
        getOfferedSubjectDAO().save(k25);
        getOfferedSubjectDAO().save(k26);
        getOfferedSubjectDAO().save(k27);
        getOfferedSubjectDAO().save(k28);

        getOfferedSubjectDAO().save(k29);
        getOfferedSubjectDAO().save(k30);
        getOfferedSubjectDAO().save(k31);
        getOfferedSubjectDAO().save(k32);

        getOfferedSubjectDAO().save(k33);
        getOfferedSubjectDAO().save(k34);
        getOfferedSubjectDAO().save(k35);
        getOfferedSubjectDAO().save(k36);

    }
}
