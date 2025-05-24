package evenAPK.authentification.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String civilite;
    @Column(nullable = true) 
    private String prenom;
    private String nom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateN; 
    private profilUser profil; 
    private String pays;
    private String ville;
    private String indicateurPays;
    private Long numero;
    private String photo;
    private String email;
    private String password;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false) 
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "boolean default false")
    private Boolean status = false;

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    
    public Users() {
    }

    // Un constructeur avec les champs obligatoires pourrait être utile
    // public Users(String email, String password, ProfilUser profil) {
    //     this.email = email;
    //     this.password = password; // Rappel: doit être un HASH
    //     this.profil = profil;
    // }


    //Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Civilite
    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    //Prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //Nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Date Naissance
    public LocalDate getDateN() {
        return dateN;
    }

    public void setDateN(LocalDate dateN) {
        this.dateN = dateN;
    }

    //Profil Utilisateur
    public profilUser getProfil() {
        return profil;
    }

    public void setProfil(profilUser profil) {
        this.profil = profil;
    }

    //Pays Utilisateur
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    //Ville Utilisateur
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    //Indice du pays de l'Utilisateur
    public String getIndicateurPays() {
        return indicateurPays;
    }

    public void setIndicateurPays(String indicateurPays) {
        this.indicateurPays = indicateurPays;
    }

    //Phone Number User
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    //Photo Profil Utilisateur
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    //Email de l'Utilisateur
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Mot de passe de l'Utilisateur
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Date de creation du compte
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    //Derniere date de Modification du compte
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    //Le statut de validation du compte lors de ca creation(PRESTATAIRE ou SUPERVISEUR) 
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //Status du compte lors de l'utilisation
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now(); 
    }

    @PreUpdate 
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}