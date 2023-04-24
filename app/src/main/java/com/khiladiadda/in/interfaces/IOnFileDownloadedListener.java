package com.khiladiadda.in.interfaces;

public interface IOnFileDownloadedListener {
    void onFileDownloaded(String filePath);

    void onFileProgressUpdate(int progress, int fileLength);
}