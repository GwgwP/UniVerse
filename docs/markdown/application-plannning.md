# Σχεδιαση Εφαρμογης 
Το **UniVerse** είναι μια εφαρμογή που προορίζεται για χρήση από φοιτητές και τη Γραμματεία της σχολής μας. 
Έτσι, έχουμε 2 ρολους που μπορούν να κάνουν log in στην εφαρμογή μας και να διαδραματίσουν τις ενέργειες που περιγράφονται στα use cases.

Για την είσοδο του <b>χρήστη</b> στην εφαρμογή χρησιμοποιούνται τα εξής views:
1. **Logo** 
    <ul>
    Πατώντας στην εικόνα του Logo ο χρήστης ανακατευθύνεται στην οθόνη Αυθεντικοποίησης 

    </ul>
    
    ![Logo](uml/requirements/logo.png)
2. **Authentication**
    <ul>
    Ο χρήστης επιλέγει τον ρόλο του μέσω ενώ switch και κάνει την αυθεντικοποίηση με βάση το id και τον κωδικό που είναι αποθηκευμένοι στο σύστημα
    </ul>

    ![Authentication](uml/requirements/authentication.png)

Για τον ρόλο του <b>φοιτητή</b> έχουμε τα εξής views:
1. **HomeStudentFragment**
    <ul>
        Περιέχει το log out button. 
    </ul>

    ![Home Student Fragment](uml/requirements/home-student-fragment.png)
1. **Student**
    <ul>
        Το Activity για τον φοιτητή. Μέσω του navigation bar ανακατευθύνει τον φοιτητή στα αντίστοιχα fragments & views. 
    </ul>

    ![Student](uml/requirements/student.png)
2. **Submission**
    <ul>
        Το Fragment που εκτελεί την δήλωση μαθημάτων του φοιτητή. Περιέχει πίνακα με τα προσφερόμενα μαθήματα για το αντιστοιχο εξάμηνο που βρίσκεται ο φοιτητής (εαρινό - χειμερινό). Ο φοιτητής επιλέγει τα μαθήματα που θέλει να δηλώσει, εκτελούνται οι απαραίτητοι έλεγχοι για τις προυποθέσεις και καταχωρείται η δήλωση (ή γίνεται ενημέρωση για μη-έγκυρη δήλωση) 
    
    </ul>

    ![Submission](uml/requirements/submission.png)
3. **Search**
    
    <ul>
        <li> <b>SearchFragment</b>
        <br>
        Το Fragment που περιέχει πίνακα με όλα τα προσφερόμενα μαθήματα. Ο φοιτητής μπορεί να κάνει αναζήτηση για κάποιο μάθημα με βάση τον τίτλο του μαθήματος, να πατήσει σε αυτό και να δει τις πληροφορίες που αφορούν σε αυτό (μέσω της ανακατεύθυνσης στο παρακάτω Activity) 
        </li> 
        
    ![Search Fragment](uml/requirements/search-fragment.png)
    
    </ul>
        <li><b>Information</b>
        <br>
        Περιέχει και παρουσιάζει τις πληροφορίες για τα μαθήματα όπως τιτλος, id, ects, περιγραφή, καθηγητής και προαπαιτούμενα μαθήματα
        </li>
    </ul>

    ![Information](uml/requirements/information.drawio.png)

4. **Progress**
    <ul>
        <li> <b>ProgressForm</b>
        <br>
        Το Fragment που περιέχει πληροφορίες όπως ο γενικός μέσος όρος και ο μέσος όρος ανά εξάμηνο, τα συνολικά ects του φοιτητή, τον αριθμό περασμένων μαθημάτων του καθώς και το κουμπί για τους λεπτομερείς βαθμούς (μέσω της ανακατεύθυνσης στο παρακάτω Activity) 
        </li> 
        <li><b>DetailedGrades</b>
        <br>
        Περιέχει και παρουσιάζει με Dynamic List τα μαθήματα που έχει εξεταστεί ο φοιτητής μαζί με τον βαθμό τους χωρισμένα ανά εξάμηνο, όπως και τον μέσο όρο για το κάθε εξάμηνο ξεχωριστά.
        </li>
    </ul>


Για τον ρόλο της <b>Γραμματείας</b> έχουμε τα εξής views:
1. **SecretaryHomeFragment**
    <ul>
        Περιέχει το log out button. 
    </ul>

    ![Secretary Home Fragment ](uml/requirements/secretary-home-fragment.png)
2. **Secretary**
    <ul>
        Το Activity για την Γραμματεία. Μέσω του navigation bar ανακατευθύνει τον Γραμματέα στα αντίστοιχα fragments & views. 
    </ul>

    ![Secretary](uml/requirements/secretary.png)
3. **AcademicYear**
    <ul>
        <li> <b>AcademicYearForm</b>
        <br>
        Το Fragment που υλοποιεί την καταχώρηση ενός περιορισμού. Περιέχει spinner για την επιλογή ακαδημαικού έτους (μεταξύ όσων έχουν δημιουργηθεί), spinner για την επιλογή του εξαμήνου, καθώς και αντίστοιχα πεδία για τη συμπλήρωση των ects, και των ημερομηνιών. Εκτελεί τον έλεγχο της δήλωσης και την καταχώρηση ή την επικάλυψη της (έαν είναι έγκυρη) 
        </li> 

    ![Academic Year ](uml/requirements/academic-year-frag.png)
    </ul>
        <li><b>Registration</b>
        <br>
        Το Activity που εκτελεί την δημιουργία νέου ακαδημαικού έτους. Ο Γραμματέας εισάγει τα κατάλληλα στοιχεία (ακαδημαικό έτος, ημερομηνίες) και το σύστημα εκτελεί την καταχώρηση. Αν υπάρχει ήδη το ακαδημαικό έτος εμφανίζεται κατάλληλο μήνυμα.   
        </li>
    </ul>

    ![Academic Year ](uml/requirements/academic-year-reg.png)
4. **OfferedSubject**
    <ul>
        <li> <b>OfferedSubjectForm</b>
        <br>
        Το Fragment στο οποίο ο Γραμματέας επιλέγει ακαδημαικό έτος και εξάμηνο. Πατώντας το κουμπί continue το σύστημα ελέγχει αν υπάρχει έστω ένα προσφερόμενο μάθημα και εκτελεί υπερκάλυψη εάν αυτό επιλεγεί από το χρήστη 
        </li> 

    ![Offerend Subject](uml/requirements/offerend-subject-form.png)
    </ul>
        <li><b>OfferedSubjectRegistration</b>
        <br>
        Το Activity κατά το οποίο ο Γραμματέας επιλέγει τα μαθήματα που θέλει να γίνουν προσφερόμενα για ένα συγκεκριμένο ακαδημαικό έτος και εξάμηνο.
        </li>
    </ul>


    ![Offerend Subject](uml/requirements/offered-subject-registration.png)
    
5. **Subject**
    <ul>
        <li> <b>SubjectFragment</b>
        <br>
        Το Fragment στο οποίο ο Γραμματέας επιλέγει να καταχωρήσει νέο Μάθημα (μέσω της ανακατεύθυνσης στο παρακάτω Activity).
        </li> 
        
     ![Subject](uml/requirements/subject-fragment.png)
    </ul>
        <li><b>SubjectAdd</b>
        <br>
        Το Activity κατά το οποίο ο Γραμματέας επιλέγει να καταχωρήσει νέο μάθημα. Εισάγει στοιχεία όπως ο τίτλος, η περιγραφή, τα ects, ο καθηγητής, και τα προαπαιτούμενα. 
        </li>
    </ul>

    ![Subject](uml/requirements/subject-add.png)
   

**Σημείωση:** <br>
Όλα τα Activities και τα Fragments που δημιουργήθηκαν συμμορφώνονται με τα αντίστοιχα UseCases και τα Requirements.

<br>

## Coverage Report

<br>

**DAO & MEMORY DAO**
<br>

![DAO & MEMORY DAO COVERAGE](uml/requirements/coverage/dao_test_coverage.jpg)

<br>

**MODEL**
<br>

![MODEL COVERAGE](uml/requirements/coverage/model_test_coverage.jpg)

<br>

**VIEW**

<br>

![VIEW PART 1](uml/requirements/coverage/view_test_coverage_1.jpg)

<br>

![VIEW PART 2](uml/requirements/coverage/view_test_coverage_2.jpg)

<br>

![VIEW PART 3](uml/requirements/coverage/view_test_coverage_3.jpg)

<br>

## Metrics 
### Class Metrics
![class metrics 1](uml/requirements/coverage/class_metrics_1_.jpg)

<br>

![class metrics 2](uml/requirements/coverage/class_metrics_2_.jpg)

<br>

### Module Metrics
![Module metrics](uml/requirements/coverage/module_metrics.jpg)

<br>

### Package Metrics

![Package metrics](uml/requirements/coverage/package_metrics.jpg)

<br>

### Project Metrics
![Project metrics](uml/requirements/coverage/projects_metrics.jpg)
