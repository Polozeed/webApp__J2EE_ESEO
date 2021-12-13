package com.beans.entity;



import javax.persistence.*;

@Table(name = "client")
@Entity
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

    public UserEntity(Integer id,String username, String password, String nom, String prenom, String mail, String adresse)
    {
        this.id =id;
        this.login = username;
        this.mdp = password;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
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


}