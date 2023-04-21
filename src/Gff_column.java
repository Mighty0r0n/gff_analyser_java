public class Gff_column {

    private String seqID;
    private String source;
    private String feature_type;
    private int feature_start;
    private int feature_end;
    private String score;
    private String strand;
    private String phase;
    private String[] attributes;

    public String getSeqID() {
        return seqID;
    }

    public void setSeqID(String seqID) {
        this.seqID = seqID;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFeature_type() {
        return feature_type;
    }

    public void setFeature_type(String feature_type) {
        this.feature_type = feature_type;
    }

    public int getFeature_start() {
        return feature_start;
    }

    public void setFeature_start(int feature_start) {
        this.feature_start = feature_start;
    }

    public int getFeature_end() {
        return feature_end;
    }

    public void setFeature_end(int feature_end) {
        this.feature_end = feature_end;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public String getDna_seq() {
        return dna_seq;
    }

    public void setDna_seq(String dna_seq) {
        this.dna_seq = dna_seq;
    }

    private String dna_seq;


    public Gff_column(String gff_line) {
        String[] collected_data_array = gff_line.split("\t");
        setSeqID(collected_data_array[0]);
        setSource(collected_data_array[1]);
        setFeature_type(collected_data_array[2]);
        setFeature_start(Integer.parseInt(collected_data_array[3]));
        setFeature_end(Integer.parseInt(collected_data_array[4]));
        setScore(collected_data_array[5]);
        setStrand(collected_data_array[6]);
        setPhase(collected_data_array[7]);
        setAttributes(collected_data_array[8].split(";"));
    }


}
