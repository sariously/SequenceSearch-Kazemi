package edu.gcccd.csis.p1;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    /**
     * Stores a found sequence (between start and end tags) into a String array and returns that array
     **/
    @Override
    public String[] getAllTaggedSequences() {
        String[] result = new String[0];
        String found = "";
        int startIndex = 0;
        int endIndex = -1;

        while (-1 != (startIndex = content.indexOf(startTag, endIndex + 1))) {
            endIndex = this.content.indexOf(this.endTag, startIndex + 1);
            found = content.substring(startIndex + startTag.length(), endIndex);
            result = adds(result, found);

        }
        return result;
    }

/**
 * Find the longest String in our String array and return it. Items of same length as existing are treated as
 *  the new longest sequence. If no items in the array, return null.
 **/
    @Override
    public String getLongestTaggedSequence() {
        String longest = "";
        String[] tagged = this.getAllTaggedSequences();
        if(tagged.length != 0) {
            for (String tag : tagged) {
                if (tag.length() >= longest.length()) {
                    longest = tag;
                }
            }

            return longest;
        }

        else {
            return null;
        }

    }

    /**
     * Displays each tagged sequence followed by its length and a new line
     **/
    @Override
    public String displayStringArray() {
        String[] tagged = this.getAllTaggedSequences();
        String display = "";
        if(tagged != null) {
            for (String tag : tagged) {
                display += tag + " : " + tag.length() + "\n";


            }
            return display;
        }
        return null;
    }

    /**
     * Removes all tags and returns cleaned up text
     **/
    @Override
    public String toString() {
        if(this.content != null)

        {
            String cleaned = this.content;

            cleaned = cleaned.replace(startTag, "");


            cleaned = cleaned.replace(endTag, "");
            return cleaned;
        }
        return null;
    }

}