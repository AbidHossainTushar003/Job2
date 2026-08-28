package com.example.job2.adapter


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.job2.R
import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ItemProfileBinding



class ProfileAdapter(

    private val onEditClick:(UserProfile)->Unit,

    private val onDeleteClick:(UserProfile)->Unit,

    private val onProfileClick:(UserProfile)->Unit,


): ListAdapter<UserProfile, ProfileAdapter.ProfileViewHolder>(DiffCallback) {





    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileViewHolder {


        val binding =
            ItemProfileBinding.inflate(

                LayoutInflater.from(parent.context),

                parent,

                false

            )


        return ProfileViewHolder(binding)

    }





    override fun onBindViewHolder(
        holder: ProfileViewHolder,
        position: Int
    ) {


        holder.bind(
            getItem(position)
        )


    }







    inner class ProfileViewHolder(

        private val binding:ItemProfileBinding

    ):RecyclerView.ViewHolder(binding.root){



        fun bind(
            profile:UserProfile
        ){
            val context = binding.root.context

            binding.txtName.text =
                context.getString(R.string.display_name, profile.name)



            binding.txtEmail.text =
                context.getString(R.string.display_email, profile.email)



            binding.txtMobile.text =
                context.getString(R.string.display_mobile, profile.mobile)





            binding.btnEdit.setOnClickListener {


                onEditClick(profile)


            }





            binding.btnDelete.setOnClickListener {


                onDeleteClick(profile)


            }






            binding.root.setOnClickListener {


                onProfileClick(profile)


            }



        }


    }





    companion object DiffCallback : DiffUtil.ItemCallback<UserProfile>() {

        override fun areItemsTheSame(
            oldItem: UserProfile,
            newItem: UserProfile,
        ): Boolean {

            return oldItem.id == newItem.id

        }



        override fun areContentsTheSame(
            oldItem: UserProfile,
            newItem: UserProfile,
        ): Boolean {

            return oldItem == newItem

        }

    }



}