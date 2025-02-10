import entidades.Casa;
import entidades.Familia;
import servicios.CasaServicio;
import servicios.FamiliaServicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

       menu();
    }

    private static void menu() {
        int opcion;
        System.out.println("Ingrese una opcion");
        opcion = scan.nextInt();
        scan.next();
        switch (opcion){
            case 1: listarFamiliasConAlMenosTresHijos(); break;
            case 2: listarCasasAgostoReinoUnido(); break;
            case 3: listarFamiliasHotmail(); break;
            case 4: buscarPorFechaYDias(); break;
            default:
                System.out.println("Se ha ingresado un valor incorrecto");

        }
    }

    private static void buscarPorFechaYDias() {
        CasaServicio casaServicio= new CasaServicio();
        System.out.println("Ingrese fecha en formato YYYY-MM-DD");
        String fecha=scan.next();
        System.out.println("Ingrese numero de dias");
        long dias = scan.nextLong();
        List<Casa> printCasas=casaServicio.ejercicioCuatro(LocalDate.parse(fecha), dias);
        for(Casa c: printCasas){
            System.out.println(c.toString());
        }
    }

    private static void listarFamiliasHotmail() {
        FamiliaServicio familiaServicio= new FamiliaServicio();
        List<Familia> printFamilias = familiaServicio.familiasHotmail();
        for(Familia f: printFamilias){
            System.out.println(f.toString());
        }

    }

    private static void listarCasasAgostoReinoUnido() {
        CasaServicio casaServicio = new CasaServicio();
        List<Casa> printCasas=casaServicio.ejercicioDos();
        for(Casa c: printCasas){
            System.out.println(c.toString());
        }
    }

    private static void listarFamiliasConAlMenosTresHijos() {
        FamiliaServicio familiaServicio= new FamiliaServicio();
        List<Familia> printFamilias = familiaServicio.listarFamiliasConAlMenosTresHijos();
        for(Familia f: printFamilias){
            System.out.println(f.toString());
        }
    }


}