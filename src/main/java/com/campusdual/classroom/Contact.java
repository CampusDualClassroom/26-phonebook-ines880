package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Contact implements ICallActions{
    private String name;
    private String surnames;
    private String mainPhone;
    private List<String> otherPhones;
    private String code;

    public Contact(String name, String surname, String mainPhone) {
    this.name = name;
    this.surnames = surname;
    this.mainPhone = mainPhone;
    this.otherPhones = new ArrayList<>();
    this.code = generateCode();
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return mainPhone;
    }

    public List<String> getOtherPhones() {
        return otherPhones;
    }

    public String getCode() {
        return code;
    }

    public void addPhone(String phone) {
        if(!phone.equals(mainPhone)) {
            otherPhones.add(phone);
        }
    }
    private String generateCode() {
     String cleanSurnames = Normalizer.normalize(surnames.toLowerCase(), Normalizer.Form.NFD)
             .replaceAll("\\p{M}", "")
             .replaceAll("\\s+", " ")
             .trim();
        String[] surnameParts = cleanSurnames.split(" ");
        String firstLetter = name.toLowerCase().substring(0,1);
        String codeResult;
        if(surnameParts.length == 1) {
            codeResult = firstLetter + surnameParts[0];
        } else {
            StringBuilder sb = new StringBuilder(firstLetter);
            sb.append(surnameParts[0].substring(0,1));
            for (int i = 1; i < surnameParts.length; i++) {
                sb.append(surnameParts[i]);
            }
            codeResult = sb.toString();
        }
        return codeResult.toLowerCase().replaceAll("\\s+", "");
    }

    public void callMyNumber() {
        System.out.println(this.name + " " + this.surnames + " se esta llamando a si mismo al numero " + mainPhone);
    }
    public void callOtherNumber(String number) {
            System.out.println(this.name + " " + this.surnames + " esta llamando al numero " + number);
        }

            public void showContactDetails() {
                System.out.println("Codigo: " + code);
                System.out.println("Nombre: " + name + " " + surnames);
                System.out.println("Numero principal: " + mainPhone);
                if (!otherPhones.isEmpty()) {
                    System.out.println("Otros numeros: " + String.join(",",otherPhones));
                }

            }
        }

















