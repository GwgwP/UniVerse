package gr.aueb.softeng.team02.model;

public abstract class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String surname;

    /**
     * Constructor of User
     *
     * @param id       the id of the user as an integer
     * @param username the username of the user as a string
     * @param password the password of the user as a string
     * @param name     the name of the user as a string
     * @param surname  the surname of the user as a string
     */
    public User(int id, String username, String password, String name, String surname) {
        // TODO id is given automatically from controller
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Get the id of the user
     *
     * @return the id as a string
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the user
     *
     * @param id the id as a string
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the username of the user
     *
     * @return the username as a string
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the user
     *
     * @param username the username as a string
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password of the user
     *
     * @return the password as a string
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user
     *
     * @param password the password as a string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the name of the user
     *
     * @return the name a string
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user
     *
     * @param name the name as a string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the surname of the user
     *
     * @return the surname as a string
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the surname of the user
     *
     * @param surname the surname as a string
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
