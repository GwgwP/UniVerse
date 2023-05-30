package gr.aueb.softeng.team02.dao;

import gr.aueb.softeng.team02.UniverseException;

public abstract class DAOFactory {
    private static DAOFactory factory = null;

    /**
     * Επιστρέφει το εργοστάσιο για την παραγωγή των
     * αντικειμένων DAO.
     *
     * @return To εργοστάσιο για την παραγωγή των DAO αντικειμένων
     */
    public static DAOFactory getFactory() {
        if (factory == null) {
            String className = null;

            if (System.getProperty("daofactory") != null) {
                className = System.getProperty("daofactory");
            }

            try {
                factory = (DAOFactory) Class.forName(className).newInstance();
            } catch (Exception e) {
                throw new UniverseException(e);
            }
        }
        return factory;
    }

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link StudentDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    public abstract StudentDAO getStudentDAO();

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link SecretaryDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    public abstract SecretaryDAO getSecretaryDAO();

    /**
     * Επιστρέφει το αντικείμενο για τη διεπαφή {@link AcademicYearDAO}.
     *
     * @return Το αντικείμενο DAO.
     */
    public abstract AcademicYearDAO getAcademicYearDAO();
}
