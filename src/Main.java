import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner file_reader = new Scanner(new File("/home/daniel/IdeaProjects/gff_analyser/gff_files/GCF_001050915.2.gff3"));
        int organism_counter = - 1;
        List<Organism> organism_array = new ArrayList<>();
        boolean has_fasta = false;
        int fasta_counter = -1;

        for (;;) {

            try {
                String gff_line = file_reader.nextLine();

                if (gff_line.startsWith("##sequence-region")) {
                    organism_counter ++;
                    Organism gff_strain = new Organism();
                    gff_strain.setStrain(gff_line.split(" ")[1]);
                    organism_array.add(gff_strain);
                } else if (organism_counter != -1 && organism_array.get(organism_counter).getStrain().equals(gff_line.split("\t")[0])) {
                    //System.out.println(gff_line.split("\t")[3]);
                    Gff_column tmp_entry = new Gff_column(gff_line);
                    organism_array.get(organism_counter).setGff_data(tmp_entry);

                } else if (gff_line.startsWith("##FASTA")) {

                    has_fasta = true;

                } else if (gff_line.startsWith(">")) {

                    if (fasta_counter > 0) {
                        organism_array.get(fasta_counter - 1).setGene_sequence();
                    }
                    fasta_counter++;

                } else if (has_fasta && !gff_line.startsWith(">")) {
                    organism_array.get(fasta_counter).setFasta_seq(gff_line);
                }
            } catch (NoSuchElementException e) {
                organism_array.get(fasta_counter).setGene_sequence();
                return;
            }
        }
    }

}