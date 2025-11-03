package com.campusdual.classroom;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {

        Phonebook pb = new Phonebook();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- MENÚ LISTÍN TELEFÓNICO ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Nombre: ");
                    String name = sc.nextLine();
                    System.out.print("Apellidos: ");
                    String surnames = sc.nextLine();
                    System.out.print("Teléfono principal: ");
                    String phone = sc.nextLine();
                    Contact c = new Contact(name, surnames, phone);

                    System.out.print("¿Quieres añadir otro número? (s/n): ");
                    String more = sc.nextLine();
                    while (more.equalsIgnoreCase("s")) {
                        System.out.print("Otro número: ");
                        String other = sc.nextLine();
                        c.addPhone(other);
                        System.out.print("¿Otro más? (s/n): ");
                        more = sc.nextLine();
                    }

                    pb.addContact(c);
                    System.out.println("Contacto añadido con código: " + c.getCode());
                    break;

                case 2:
                    pb.showPhonebook();
                    break;

                case 3:
                    System.out.print("Introduce el código del contacto: ");
                    String code = sc.nextLine();
                    Contact selected = pb.getData().get(code);
                    if (selected != null) {
                        boolean back = false;
                        while (!back) {
                            System.out.println("\n--- MENÚ DE CONTACTO ---");
                            System.out.println("1. Ver detalles");
                            System.out.println("2. Llamarse a sí mismo");
                            System.out.println("3. Llamar a otro número");
                            System.out.println("4. Volver");
                            System.out.print("Elige una opción: ");
                            int subOption = sc.nextInt();
                            sc.nextLine();

                            switch (subOption) {
                                case 1:
                                    selected.showContactDetails();
                                    break;
                                case 2:
                                    selected.callMyNumber();
                                    break;
                                case 3:
                                    System.out.print("Número a llamar: ");
                                    String num = sc.nextLine();
                                    selected.callOtherNumber(num);
                                    break;
                                case 4:
                                    back = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                        }
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el código del contacto a eliminar: ");
                    String delCode = sc.nextLine();
                    if (pb.getData().containsKey(delCode)) {
                        pb.deleteContact(delCode);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Código no encontrado.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}

