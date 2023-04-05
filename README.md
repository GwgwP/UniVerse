# INF138 Project Template - ``UniVerse``

Ένα απλό πρότυπο οργάνωσης του κώδικα και της τεχνικής τεκμηρίωσης για τις εξαμηνιαίες εργασίες του μαθήματος Τεχνολογία Λογισμικού ([INF138](https://eclass.aueb.gr/courses/INF138/)) του Τμήματος Πληροφορικής Οικονομικού Πανεπιστημίου Αθηνών.

Η τρέχουσα έκδοση περιλαμβάνει την [προδιαγραφή των απαιτήσεων λογισμικού](docs/markdown/software-requirements.md) με προσαρμογή του `IEEE Std 830-1998` για την ενσωμάτωση απαιτήσεων σε μορφή περιπτώσεων χρήσης. Για περισσότερες λεπτομέρειες μπορείτε να ανατρέξετε στο βιβλίο [Μ Γιακουμάκης, Ν. Διαμαντίδης, Τεχνολογία Λογισμικού, Σταμούλης, 2009](https://www.softeng.gr).
##  **Εισαγωγή**
Το <mark style= 'color:royalblue; background-color: transparent'>UniVerse</mark> έχει σκοπό να εξυπηρετήσει την ακαδημαική κοινότητα, απευθυνόμενη στους φοιτητές και την γραμματεία του Οικονομικού Πανεπιστημίου Αθηνών. Σκοπός της είναι ο φοιτητής να δύναται να δει τις πληροφορίες των προσφερόμενων μαθημάτων, τους βαθμούς του, τα στατιστικα στοιχεία του και τέλος να υποβάλει την δήλωση μαθημάτων. Επιπλέον, θα υποστηρίζει τον υπεύθυνο γραμματείας με την καταχώρηση των πληροφοριών των μαθημάτων, την επιλογή των προσφερόμενων μαθημάτων ανά έτος και εξάμηνο καθώς και την καταχώρηση προυποθέσεων (προαπαιτούμενα κ.λπ.), αυτοματοποιώντας πολλές από τις υποχρεώσεις της γραμματείας.

##  Περιγραφή του πεδίου προβλήματος
-	Το σύστημα θα υποστηρίζει τα καθήκοντα του υπεύθυνου γραμματείας και των φοιτητών της σχολής. Επιπλέον, ορισμένες λειτουργίες θα υποστηρίζονται με την βοήθεια του φοιτητολογίου και του ημερολογίου του συστήματος.
-	Ο **υπεύθυνος γραμματείας** θα έχει την δυνατότητα να εκτελεί τα εξής :
    -	Καταχωρεί τα μαθήματα και τις πληροφορίες του (Τίτλος, Διδάσκων, περιγραφή, προαπαιτούμενα μαθήματα, ΕCTS) (*με βάση τον οδηγό σπουδών*).
    -  	Επιλέγει και καταχωρεί τα προσφερόμενα μαθήματα για κάθε ακαδημαϊκό έτος και εξάμηνο σπουδών.
    -   Ορίζει τις απαραίτητες προυποθέσεις (μαθήματα αλυσίδας, ανώτατο όριο ECTS ανά έτος) για τις δηλώσεις μαθημάτων.
-   Ο **φοιτητής** θα μπορεί να :
    -	Επιλέγει το τρέχον εξάμηνο σπουδών και ακαδημαϊκό έτος. Στη συνέχεια διαλέγει τα μαθήματα στα οποία θα εξεταστεί (Δημιουργία δήλωσης μαθημάτων εξαμήνου).
    -	Παρακολουθεί την αναλυτική βαθμολογία για τα μαθήματα που έχει περάσει, όπου για κάθε μάθημα θα εμφανίζεται μεταξύ άλλων ο βαθμός και το ακαδημαϊκό εξάμηνο που αποδόθηκε.
    -   Ενημερώνεται αναλύτικα για τις πληροφορίες των μαθημάτων που του προσφέρονται. 
-	Το **Ημερολόγιο Συστήματος** δύναται να :
    -	Διαχειρίζεται την προθεσμία υποβολής δηλώσεων μαθημάτων
    -   Εγκρίνει την υποβολή βαθμών των εξεταστέων μαθημάτων μετά το πέρας της καταληκτικής ημερομηνίας.
-   Το **Φοιτητολόγιο** μπορεί να :
    -   Προσθέσει τους καινούργιους βαθμούς της εξεταστικής.

-	Η πρόσβαση στο σύστημα θα γίνεται μέσω παροχής κατάλληλων διαπιστευτηρίων.
-	Το σύστημα θα ανανεώνει τα στατιστικά δεδομένα των φοιτητών με την υποβολή κάθε βαθμού μαθήματος.
-   Το σύστημα θα ελέγχει τις δηλώσεις των μαθημάτων των φοιτητών και θα τις εγκρίνει με βάση τις προυποθέσεις.

### `Απαιτήσεις Λογισμικού σε μορφή κειμένου`
> - Το σύστημα αναφέρεται σε δύο βασικούς **stakeholders**, τους φοιτητές και προσωπικό γραμματείας, ενώ θα συντονίζονται ορισμένες δυνατότητες του από λειτουργίες του Φοιτητολογίου και Ημερολογίου του Συστήματος.  
> - Το <mark style= 'color:gray; background-color: black'>προσωπικό γραμματείας</mark> θα εκχωρεί στο σύστημα πληροφορίες κάθε μαθήματος(*περιγραφή, τίτλος, προαπαιτούμενα μαθήματα, ECTS, διδάσκοντας καθηγητής κλπ*) καθώς και για κάθε ακαδημαικό έτος και εξάμηνο σπουδών, τα προσφερόμενα μαθήματα στα οποία μπορεί να εξεταστεί ο φοιτητής. Οι <mark style= 'color:gray; background-color: black'>φοιτητές</mark> θα μπορούν να δουν τις πληροφορίες του μαθήματος, να επιλέξουν ακαδημαικό έτος και εξάμηνο και να κάνουν δήλωση μαθημάτων. Επίσης η εφαρμογή λογισμικού θα παράγει στατιστικά στοιχεία για κάθε φοιτητή, στα οποία θα έχει πρόσβαση πριν και μετά το πέρας της εξεταστικής περιόδου. Για την διεξαγωγή δήλωσης μαθημάτων, τον έλεγχο αναλαμβάνει τόσο το σύστημα με την διασφάλιση της ύπαρξης των προυποθέσεων, αλλά και το <mark style= 'color:gray; background-color: black'>ημερολόγιο του συστήματος</mark>, που διασφαλίζει την τήρηση της προθεσμίας υποβολής των μαθημάτων. Επιπλέον, το δεύτερο επιτρέπει στο <mark style= 'color:gray; background-color: black'>φοιτητολόγιο</mark> να περάσει τους βαθμούς στο λογισμικό μετά την καταληκτική ημερομηνία. Τέλος, το υπό ανάπτυξη σύστημά μας διασφαλίζει την ταυτοποίηση των χρηστών του με την είσοδο τους.

| <center>***Παραδοχές***</center> |
| --------------- |
|1. Θεωρούμε ότι τα δηλωμένα μαθήματα από τους φοιτητές είναι ταυτόχρονα και εξεταστέα |
|2. Θεωρούμε ότι οι καθηγητές δηλώνουν τους βαθμούς των εξεταστέων μαθημάτων στο φοιτητολόγιο |
|3. Η επιλογή των προσφερόμενων μαθημάτων από την γραμματεία προυποθέτει να έχουν καταχωρηθεί τα υφιστάμενα μαθήματα (προσφερόμενα ή μη)|

## Uml Use-Case Diagram
![Εναλλακτικό κείμενο](docs/markdown/uml/requirements/UseCase.jpg "UseCase Diagram")

# Ειδικές Απαιτήσεις
## Περιπτώσεις Χρήσης

### Περιγραφές περιπτώσεων χρήσης 
| Περιπτώσεις χρήσης | Τίτλος | Περιγραφή |
| :-----| :--------------| :------------------------------|
| ΠΧ 1 | Ταυτοποίηση Χρηστών | Το σύστημα ταυτοποιεί και ευθεντικοποιεί τους χρήστες (Γραμματεία & Φοιτητές)|
| ΠΧ 2 | Καταχώρηση Μαθημάτων | Ο Υπεύθυνος Γραμματείας καταχωρεί τα μαθήματα (πληροφορίες κλπ ) της σχολής  |
| ΠΧ 3 | Καταχώρηση Προυποθέσεων | Ο Υπεύθυνος Γραμματείας εισαγάγει τις προυποθέσεις (προαπαιτούμενα, αλυσίδες) όλων των μαθημάτων καθώς και τα όρια των ECTS που μπορούν να δηλωθούν από τους φοιτητές ανά έτος  |
| ΠΧ 4 | Καταχώρηση Προσφερόμενων Μαθημάτων | Ο Υπεύθυνος Γραμματείας επιλέγει και καταχωρεί τα μαθήματα που θα προσφερθούν το συγκεκριμένο έτος |
| ΠΧ 5 | Παρουσίαση Πληροφοριών Μαθημάτων | Ο φοιτητής βλέπει τις πληροφορίες που τον ενδιαφέρουν για τα μαθήματα που προσφέρονται. (Τίτλος, ECTS, αλυσίδες, προαπαιτούμενα) |
| ΠΧ 6 | Δήλωση Μαθημάτων | Ο φοιτητής επιλέγει τα μαθήματα στα οποία θέλει να εξεταστεί το τρέχον εξάμηνο, όταν αυτό γίνει διαθέσιμο από το Ημερολόγιο Συστήματος |
| ΠΧ 7 | Καταχώρηση Βαθμών | Το φοιτητολόγιο καταχωρεί τους βαθμούς των φοιτητών στα μαθήματα που δήλωσαν, μετά την ενεργοποίηση της λειτουργίας από το Ημερολόγιο Συστήματος |
| ΠΧ 8 | Προβολή Στατιστικών Στοιχείων | Ο φοιτητής δύναται να βλέπει τους βαθμούς του καθώς και στατιστικά στοιχεία προόδου |

