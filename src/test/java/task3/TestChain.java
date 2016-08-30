package task3;

import com.epam.perkovdenys.task3.part2.filters.FileFormatFilter;
import com.epam.perkovdenys.task3.part2.filters.FileNameFilter;
import com.epam.perkovdenys.task3.part2.filters.FileRangeDateFilter;
import com.epam.perkovdenys.task3.part2.filters.FileRangeSizeFilter;
import org.junit.Assert;

import org.junit.Test;

import java.io.File;

public class TestChain {


    @Test
    public void fileFormatFilter(){
        Assert.assertTrue(FileFormatFilter.getFormatFilter("txt").apply(new File("file.txt")));
        Assert.assertTrue(FileFormatFilter.getFormatFilter("mp3").apply(new File("song.mp3")));
        Assert.assertTrue(FileFormatFilter.getFormatFilter("jpg").apply(new File("image.jpg")));
        Assert.assertFalse(FileFormatFilter.getFormatFilter("-").apply(new File("image.jpg")));
    }

    @Test
    public void fileNameFilter(){
        Assert.assertTrue(FileNameFilter.getNameFilter("abc").apply(new File("abc.txt")));
        Assert.assertTrue(FileNameFilter.getNameFilter("song").apply(new File("song.mp3")));
        Assert.assertTrue(FileNameFilter.getNameFilter("image").apply(new File("image.jpg")));
        Assert.assertFalse(FileNameFilter.getNameFilter("-").apply(new File("image.jpg")));
    }

    @Test
    public void fileRangeSizeFilter(){
        Assert.assertFalse(FileRangeSizeFilter.getRangeSizeFilter(1, 1000).apply(new File("file2.txt")));
    }

    @Test
    public void fileRangeDateFilter(){
        Assert.assertFalse(FileRangeDateFilter.getRangeDateFilter("2010-10-10", "2017-11-11").apply(new File("file.txt")));
    }
}
