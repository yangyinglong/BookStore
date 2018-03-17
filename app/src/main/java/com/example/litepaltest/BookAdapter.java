package com.example.litepaltest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 她是龙 on 2018/3/15.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> mBookList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookName;
        TextView bookAuthor;
        TextView bookPrice;
        TextView bookPages;
        TextView bookId;

        public ViewHolder(View view){
            super(view);
            bookId = (TextView) view.findViewById(R.id.book_id);
            bookName = (TextView) view.findViewById(R.id.book_name);
            bookAuthor = (TextView) view.findViewById(R.id.book_author);
            bookPages = (TextView) view.findViewById(R.id.book_pages);
            bookPrice = (TextView) view.findViewById(R.id.book_price);
        }
    }

    public BookAdapter(List<Book> bookList){
        mBookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Book book = mBookList.get(position);
        holder.bookId.setText(String.valueOf(book.getId()));
        holder.bookName.setText(book.getName());
        holder.bookAuthor.setText(book.getAuthor());
        holder.bookPrice.setText(String.valueOf(book.getPrice()));
        holder.bookPages.setText(String.valueOf(book.getPages()));

    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }

}
