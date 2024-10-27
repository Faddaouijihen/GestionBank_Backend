package com.GestionBank.GestionBank.services;

import com.GestionBank.GestionBank.dto.CompteBancaireDTO;
import com.GestionBank.GestionBank.entities.*;
import com.GestionBank.GestionBank.enums.AccountStatus;
import com.GestionBank.GestionBank.repository.CompteBancaireRepository;
import com.GestionBank.GestionBank.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompteBancaireServiceImpl implements CompteBancaireService {
    private final CompteBancaireRepository bancaireRepository;
    private final PersonRepository personRepository;
    private final EmailService emailService;

    CompteBancaireServiceImpl(
            final CompteBancaireRepository bancaireRepository,
            final PersonRepository personRepository,
            final EmailService emailService
    ) {
        this.bancaireRepository = bancaireRepository;
        this.personRepository = personRepository;
        this.emailService = emailService;
    }

    @Override
    public void createCompte(CompteBancaireDTO dto) {
        Client client = null;
        boolean isPresent = this.personRepository.findById(dto.getClientId()).isPresent();

        if (isPresent && dto.getDecouvert() == 0 && dto.getTauxInteret() > 0) {
            Optional<Person> clientOpt = this.personRepository.findById(dto.getClientId());
            if (clientOpt.isPresent() && clientOpt.get() instanceof Client) {
                client = (Client) clientOpt.get();
                CompteEpargne compteEpargne = new CompteEpargne();
                compteEpargne.setClient(client);
                compteEpargne.setCreatedAt(new Date());
                compteEpargne.setDevis("CFA");
                compteEpargne.setBalance(dto.getBalance());
                compteEpargne.setTauxInteret(dto.getTauxInteret());
                compteEpargne.setStatus(AccountStatus.ACTIVATED);
                compteEpargne.setNumCompte(generateAccountNumber(5));
                this.bancaireRepository.save(compteEpargne);

                emailService.sendNotificationEmail(client.getEmail(),
                        "Notification, Création de Compte",
                        "Bonjour cher client : " + client.getFirstName() + " " + client.getLastName() +
                                ". Vous avez créé un compte, pour accéder à votre espace et pour suivre votre inscription, voici vos identifiants de connexion : " +
                                "LOGIN : " + client.getEmail() + ", Mot de passe : " + generateAccountNumber(6));
            } else {
                throw new RuntimeException("Client avec l'ID " + dto.getClientId() + " n'existe pas ou n'est pas de type Client !");
            }
        }

        if (isPresent && dto.getTauxInteret() == 0 && dto.getDecouvert() > 0) {
            Optional<Person> clientOpt = this.personRepository.findById(dto.getClientId());
            if (clientOpt.isPresent() && clientOpt.get() instanceof Client) {
                client = (Client) clientOpt.get();
                CompteCourant compteCourant = new CompteCourant();
                compteCourant.setClient(client);
                compteCourant.setBalance(dto.getBalance());
                compteCourant.setDevis("CFA");
                compteCourant.setCreatedAt(new Date());
                compteCourant.setDecouvert(dto.getDecouvert());
                compteCourant.setStatus(AccountStatus.ACTIVATED);
                compteCourant.setNumCompte(generateAccountNumber(5));
                this.bancaireRepository.save(compteCourant);

                emailService.sendNotificationEmail(client.getEmail(),
                        "Notification, Création de Compte",
                        "Bonjour cher client : " + client.getFirstName() + " " + client.getLastName() +
                                ". Vous avez créé un compte, pour accéder à votre espace et pour suivre votre inscription, voici vos identifiants de connexion : " +
                                "LOGIN : " + client.getEmail() + ", Mot de passe : " + generateAccountNumber(6));
            } else {
                throw new RuntimeException("Client avec l'ID " + dto.getClientId() + " n'existe pas ou n'est pas de type Client !");
            }
        }
    }

    @Override
    public List<CompteCourant> findAllCompteCourant() {
        List<CompteCourant> l = new ArrayList<>();
        for (AccountBank c : this.bancaireRepository.findAll()) {
            if (c instanceof CompteCourant)
                l.add((CompteCourant) c);
        }
        return l;
    }

    @Override
    public List<CompteEpargne> findAllCompteEpargne() {
        List<CompteEpargne> l = new ArrayList<>();
        for (AccountBank c : this.bancaireRepository.findAll()) {
            if (c instanceof CompteEpargne)
                l.add((CompteEpargne) c);
        }
        return l;
    }

    @Override
    public CompteEpargne findCompteEpargne(String numCompte) {
        return (CompteEpargne) this.bancaireRepository.findByNumCompte(numCompte)
                .orElseThrow(() -> new RuntimeException("Ce compte n'existe pas !"));
    }

    @Override
    public CompteCourant findCompteCourant(String numCompte) {
        return (CompteCourant) this.bancaireRepository.findByNumCompte(numCompte)
                .orElseThrow(() -> new RuntimeException("Ce compte n'existe pas !"));
    }

    @Override
    public AccountBank suspendCompte(String numCompte) {
        Optional<AccountBank> compte = this.bancaireRepository.findByNumCompte(numCompte);
        if (compte.isPresent() && compte.get().getStatus().equals(AccountStatus.ACTIVATED)) {
            AccountBank c = compte.get();
            c.setStatus(AccountStatus.SUSPENDED);
            return this.bancaireRepository.save(c);
        }
        return null;
    }

    @Override
    public AccountBank activeCompte(String numCompte) {
        Optional<AccountBank> compte = this.bancaireRepository.findByNumCompte(numCompte);
        if (compte.isPresent() && compte.get().getStatus().equals(AccountStatus.SUSPENDED)) {
            AccountBank c = compte.get();
            c.setStatus(AccountStatus.ACTIVATED);
            return this.bancaireRepository.save(c);
        }
        return null;
    }

    @Override
    public List<AccountBank> findAllCompteClientById(long id) {
        return List.of();
    }

    @Override
    public List<AccountBank> findAllComptesCreatedByEmployeeById(long id) {
        return List.of();
    }

    private static String generateAccountNumber(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append("0");
        }
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(2));
        }
        for (int i = 0; i < n; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
