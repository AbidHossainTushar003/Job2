package com.example.job2.adapter


import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.example.job2.data.model.UserProfile
import com.example.job2.databinding.ItemProfileBinding



class ProfileAdapter(

    private val onEditClick:(UserProfile)->Unit,

    private val onDeleteClick:(UserProfile)->Unit,

    private val onProfileClick:(UserProfile)->Unit


): RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {



    private var profileList =
        emptyList<UserProfile>()





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
            profileList[position]
        )


    }





    override fun getItemCount(): Int {

        return profileList.size

    }







    fun submitList(
        list:List<UserProfile>
    ){

        profileList = list

        notifyDataSetChanged()

    }







    inner class ProfileViewHolder(

        private val binding:ItemProfileBinding

    ):RecyclerView.ViewHolder(binding.root){



        fun bind(
            profile:UserProfile
        ){


            binding.txtName.text =
                profile.name



            binding.txtEmail.text =
                profile.email



            binding.txtMobile.text =
                profile.mobile





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



}