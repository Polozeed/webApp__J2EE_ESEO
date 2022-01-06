package com.beans.entity;



import javax.persistence.*;
import javax.persistence.Entity;


//----------------------------------------// Entity Client//--------------------------------------
@Table(name = "client")
@Entity(name = "UserEntity")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 60)
    private String login;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "nom", nullable = false, length = 60)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 60)
    private String prenom;

    @Column(name = "mail", nullable = false, length = 60)
    private String mail;

    @Column(name = "adresse_livraison", nullable = false, length = 60)
    private String adresse;


    @Column(name = "est_bloque", nullable = true)
    private Boolean est_bloque;

    @Column(name = "token", nullable = true)
    private String token;


    public UserEntity(String username, String password, String nom, String prenom, String mail, String adresse,String token, Boolean est_bloque)
    {
        this.login = username;
        this.mdp = password;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.token = token;
        this.est_bloque = est_bloque;
    }

    public UserEntity(int id,String username, String password, String nom, String prenom, String mail, String adresse,String token, Boolean est_bloque)
    {
        this.id =id;
        this.login = username;
        this.mdp = password;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.token = token;
        this.est_bloque = est_bloque;
    }

    public UserEntity()
    {
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setMdp(String password)
    {
        this.mdp = password;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String username)
    {
        this.login = username;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Boolean getEst_bloque() {
        return est_bloque;
    }

    public void setEst_bloque(Boolean est_bloque) {
        this.est_bloque = est_bloque;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isComplete()
    {
        if (!this.login.isEmpty() &&
                !this.mdp.isEmpty() &&
                !this.nom.isEmpty() &&
                !this.prenom.isEmpty() &&
                !this.adresse.isEmpty() &&
                !this.mail.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", est_bloque=" + est_bloque +
                ", token='" + token + '\'' +
                '}';
    }
}