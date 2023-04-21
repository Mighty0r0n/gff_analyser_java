import java.util.ArrayList;
import java.util.List;

public class Organism {

    private String strain;
    private List<Gff_column> gff_data = new ArrayList<>();
    private StringBuilder fasta_seq = new StringBuilder("");
    private StringBuilder fasta_seq_printable = new StringBuilder("");

    public StringBuilder getFasta_seq() {
        return fasta_seq;
    }


    public void setGene_sequence() {
        for (int i=0;i<this.gff_data.size();i++) {

            this.gff_data.get(i).setDna_seq(this.fasta_seq.substring(this.gff_data.get(i).getFeature_start() - 1, this.gff_data.get(i).getFeature_end()-1));
        }
    }

    public void setFasta_seq(String fasta_seq) {
        this.fasta_seq.append(fasta_seq);
        this.fasta_seq_printable.append(fasta_seq);
        this.fasta_seq_printable.append("\n");

    }

    public Organism find_organism(List<Organism> organism_list, String strain) {
        for (int i=0; i < organism_list.size(); i++) {
            if (strain.equals(organism_list.get(i).getStrain())) {
                return organism_list.get(i);
            }
        }
        return null;
    }

    public List<Gff_column> getGff_data() {
        return gff_data;
    }

    public void setGff_data(Gff_column gff_data) {
        this.gff_data.add(gff_data);
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }


    public void set_dna_seq(List<Gff_column> gff_data) {

        for (int i = 0; i < gff_data.size(); i++) {
            System.out.println(gff_data.get(i));
        }

    }

}
